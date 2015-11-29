package photohack.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import photohack.models.Image;
import photohack.models.ImageDao;
import photohack.models.Tag;
import photohack.models.TagDao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TaggingSearchThread implements Runnable{

	private Image image;
	
	private TagDao tagDao;

	private ImageDao imageDao;
	
	public TaggingSearchThread(Image image, TagDao tagDao, ImageDao imageDao) {
		this.image = image;
		this.tagDao = tagDao;
		this.imageDao = imageDao;
	}
	 
	public void run() {
		String urlString = image.getImageUrl();
		try {
			URL url = new URL(urlString);
			System.out.println(urlString);
			File file = new File("/tmp/"+image.getUuid()+".jpg");
			FileUtils.copyURLToFile(url, file);
			System.out.println(file.getAbsolutePath());
			if(file.canRead()) {
				
				//String resultUrl = runCurlAndGetLocation(file);
				
				//curl -i -XPOST https://vision.eyeem.com/photohackday/photos -H "Authorization: PHOTOHACKDAY123" -T "/path/to/your/photo.jpg"
				final InputStream stream = new FileInputStream(file);
				
				final byte[] bytes = new byte[stream.available()];
				stream.read(bytes);
				stream.close();

				HttpResponse<JsonNode> jsonResponse = Unirest.post("https://vision.eyeem.com/photohackday/photos")
				  .header("Accept", "application/json")
				  .header("Content-type", "image/jpg")
				  .header("Authorization", "PHOTOHACKDAY123")
				  .body(bytes)
				  .asJson();
				
				JsonNode node = jsonResponse.getBody();
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(node.getObject().has("location")) {
					String resultUrl = node.getObject().getString("location");
					
					System.out.println(resultUrl);
					HttpResponse<JsonNode> jsonResponse2 = Unirest.get(resultUrl)
							  .header("Accept", "application/json")
							  .header("Authorization", "PHOTOHACKDAY123")
							  .asJson();
					
					node = jsonResponse2.getBody();
					System.out.println(node.getObject().toString());
					if(node.getObject().has("aestheticsScore")) {
						Double score = node.getObject().getDouble("aestheticsScore");
						image.setScore(score);
						JSONArray concepts = node.getObject().getJSONArray("concepts");
						List<Tag> tags = image.getTags();
						for(int i = 0; i<concepts.length(); i++) {
							String concept = concepts.get(i).toString();
							Tag tag = tagDao.findByText(concept);
							if(tag == null) {
								tag = new Tag();
							}
							tag.setText(concept);
							tagDao.save(tag);
							tags.add(tag);
						}
						image.setTags(tags);
						imageDao.save(image);
					}
				}
			}
		} catch (IOException | UnirestException e) {
			System.out.println("Error");
			//e.printStackTrace();
		}

	}

		
}
