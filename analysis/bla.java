import java.io.*;

class bla
{
	public bla()
	{
		try{
		//System.out.println("hi");
		Process p=Runtime.getRuntime().exec("python /home/john/phd4/analysis/detect_emotion.py fun ratings.csv");
		p.waitFor();
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				//.append(line + "\n");
				System.out.println(line);
			}
		}catch(Exception e){e.printStackTrace();}
		
	}

	public static void main(String[] args)
	{
		new bla();
	}
}
