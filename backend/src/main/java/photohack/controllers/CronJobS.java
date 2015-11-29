package photohack.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import photohack.models.Image;
import photohack.models.ImageDao;
import photohack.models.TagDao;

@Controller
public class CronJobS {

	@Autowired(required = true)
	private ImageDao imageDao;

	@Autowired(required = true)
	private TagDao tagDao;
	
	@Autowired
	private NarrativePhotoUploader uploader;
	
	@Autowired
	private TaggingSearchThread thread;
	
	@Autowired
	private EmotionTaggingTask emotion;
	
	public void execute() {
		uploader.run();
		Iterable<Image> images = imageDao.findByScoreNull();
		if(images != null)
		for(Image image : images) {
			if(image.getScore() != null) {
				thread.run(image);
			}
		}
		emotion.run();
	}
	
}
