package photohack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import photohack.models.Image;
import photohack.models.ImageDao;
import photohack.models.Photo;
import photohack.models.Tag;
import photohack.models.TagDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class MainController {
	
	@Autowired(required = true)
	private CronJobS service;
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private TagDao tagDao;

  @RequestMapping("/update")
  @ResponseBody
  public String index() {
	service.execute();
    return "Update done!";
  }
  
  @RequestMapping("/photos/by-emotion/{emotion}")
  public List<Photo> getPhotos(@PathVariable String emotion) {
	  List<Photo> photos = new ArrayList<>();
	  for(Image image : imageDao.findByEmotion(emotion)) {
		  Photo photo = new Photo();
		  photo.imageUrl = image.getImageUrl();
		  photo.score = image.getScore();
		  List<String> tags = new ArrayList<>();
		  for(Tag tag : image.getTags()) {
			  tags.add(tag.getText());
		  }
		  photo.date = image.getCreatedDate();
		  photo.tags = (String[]) tags.toArray(new String[tags.size()]);
		  photo.arousal = image.getArousal();
		  photo.valence = image.getValence();
		  photo.lenght = image.getLenght();
		  photo.emotion = image.getEmotion();
		  photos.add(photo);
	  }
	  return photos;
  }
  
}
