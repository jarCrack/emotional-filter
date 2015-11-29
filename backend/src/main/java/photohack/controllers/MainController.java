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

  @RequestMapping("/")
  @ResponseBody
  public String index() {
	service.execute();
    return "Update done!";
  }
  
  @RequestMapping("/photos/by-emotion/{emotion}")
  public List<Photo> getPhotos(@PathVariable String emotion) {
	  List<Photo> photos = new ArrayList<>();
	  for(Image image : imageDao.findAll()) {
		  Photo photo = new Photo();
		  photo.imageUrl = image.getImageUrl();
		  photo.score = image.getScore();
		  List<String> tags = new ArrayList<>();
		  for(Tag tag : image.getTags()) {
			  tags.add(tag.getText());
		  }
		  photo.tags = (String[]) tags.toArray(new String[tags.size()]);
		  photo.arousal = (Math.random() * 10) -5;
		  photo.valence = (Math.random() * 10) -5;
		  photos.add(photo);
	  }
	  return photos;
  }
  
}
