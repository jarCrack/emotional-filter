package photohack.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import photohack.models.Image;
import photohack.models.ImageDao;

@Component
public class NarrativePhotoUploader{

	@Autowired
	private ImageDao imageDao;
	
	public void run() {
		try {
            // get URL content

        	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        	String nowAsString = df.format(new Date());
        	System.out.println(nowAsString);
        
            String a="https://narrativeapp.com/api/v2/photos/"+
            "?taken_at_local__gte="+nowAsString+
            "&limit=1000";
            
        	URL url = new URL(a);
        	HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        	
            // request grant:
            con.setRequestProperty("Authorization","Bearer Z6tJFZJt8lbUAoJ8IDGiShkr60iHPU");
            con.setRequestProperty("Accept", "application/json");
            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(con.getInputStream()));

            String result="";
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
            	result+=inputLine+System.getProperty("line.separator");
            }
            br.close();
           
            JSONObject obj = new JSONObject(result);
            JSONArray results= obj.getJSONArray("results");
            for(int j=0;j<results.length();j++){
            	JSONObject cur_img=results.getJSONObject(j);
            	String uuid = cur_img.getString("uuid");
            	String urls = cur_img.getJSONObject("renders").getJSONObject("g1_hd").getString("url");
            	String date = cur_img.getString("taken_at_local");
            	if(!imageDao.exists(uuid)) {
	            	Image image = new Image();
	            	image.setUuid(uuid);
	            	image.setImageUrl(urls);
	            	try {
						image.setCreatedDate(df.parse(date));
					} catch (ParseException e) {
						e.printStackTrace();
					}
	            	imageDao.save(image);
            	}
            }
            System.out.println(result);
            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
