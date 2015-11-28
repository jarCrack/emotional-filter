import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.json.*;



public class NarrativeAccess {

	public NarrativeAccess()
	{
		
        try {
            // get URL content

        	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        	String nowAsString = df.format(new Date());
        	System.out.println(nowAsString);
        
        	
            String a="https://narrativeapp.com/api/v2/photos/"+
            "?taken_at_local__gte="+nowAsString+
            "&limit=10";
            
        	URL url = new URL(a);
        	HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        	
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
            	System.out.println(cur_img.getString("uuid"));
            	
            	//System.out.println(results.length());
            }

           
            System.out.println(result);
            
            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


	}
	
	
	
	public static void main(String[] args)
	{
		// connect with Narrative API
		
		new NarrativeAccess();
	}
}

