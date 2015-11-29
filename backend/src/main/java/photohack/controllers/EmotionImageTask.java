package photohack.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import photohack.models.Image;
import photohack.models.ImageDao;
import photohack.models.Tag;

public class EmotionImageTask implements Runnable{

	@Autowired
	private ImageDao imageDao;
	
	@Override
	public void run() {
		for(Image image : imageDao.findAll()) {
			double arousal = 0;
			double valence = 0;
			for(Tag tag : image.getTags()) {
				arousal += tag.getArousal();
				valence += tag.getValence();
			}
			arousal = arousal / image.getTags().size();
			valence = valence / image.getTags().size();
			image.setArousal(arousal);
			image.setValence(valence);
			imageDao.save(image);
		}
	}

}
