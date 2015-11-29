package photohack.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import antlr.StringUtils;
import photohack.models.Tag;
import photohack.models.TagDao;

@Component
public class EmotionTaggingTask implements Runnable{


	@Autowired
	private TagDao tagDao;
	
	@Override
	public void run() {
		for(Tag tag : tagDao.findAll()) {
			try {
				if(tag.getEmotion() == null || tag.getEmotion().equals("")) {
					String command = "python /Users/susannaferrari/Projects/emotional-filter/analysis/detect_emotion.py "
							+ tag.getText()
							+ " /Users/susannaferrari/Projects/emotional-filter/analysis/ratings.csv";
					Process p = Runtime.getRuntime().exec(command);
				   // System.out.println(command);
				    p.waitFor();
					BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
					
				    String arousal = br.readLine();
				    String valence = br.readLine();
				    String emotion = br.readLine();
				    p.destroy();
				    if(arousal != null && !arousal.equals("") && valence != null && !valence.equals("") ) {
					    tag.setArousal(Double.parseDouble(arousal));
					    tag.setValence(Double.parseDouble(valence));
					    tag.setEmotion(emotion);
				    }
				    tagDao.save(tag);
				}
			} catch (IOException | InterruptedException e)  {
				//e.printStackTrace();
			}
		}
	}

	
}
