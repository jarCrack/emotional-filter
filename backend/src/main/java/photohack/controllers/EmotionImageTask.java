package photohack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import photohack.models.Image;
import photohack.models.ImageDao;
import photohack.models.Tag;

@Component
public class EmotionImageTask implements Runnable{

	@Autowired
	private ImageDao imageDao;
	
	@Override
	public void run() {
		for(Image image : imageDao.findAll()) {
			int size = image.getTags().size();
			if(size > 0) {
				double[] arousals = new double[size];
				double[] valences = new double[size];
				int i=0;
				double arousal = 0;
				double valence = 0;
				for(Tag tag : image.getTags()) {
					arousals[i] += tag.getArousal();
					valences[i] += tag.getValence();
					arousal += tag.getArousal();
					valence += tag.getValence();
					
					i++;
				}
				arousal = arousal / size;
				valence = valence / size;
				double lenght = Math.sqrt(arousal * arousal + valence * valence);
				image.setArousal(arousal);
				image.setValence(valence);
				image.setLenght(lenght);
				// get emotion by arousal and valence 
				String emotion = PicAnalizer.analize(arousals, valences);
				image.setEmotion(emotion);
				imageDao.save(image);
			}
		}
	}

}
