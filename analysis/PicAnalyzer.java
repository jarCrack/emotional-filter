import java.util.*;

public class PicAnalyzer
{
	public PicAnalyzer()
	{
		String[] emotions={"pleased","excited","aroused","distressed","miserable","depressed","sleepy","relaxed"};

		double[] arousals={1.,2.,3.};
		double[] valances={-1.,-2.,-3.};

		double arousal_tot=0.;
		double valance_tot=0.;
		for(int i=0;i<arousals.length;i++){
			arousal_tot+=arousals[i];
			valance_tot+=valances[i];
		}

		double length=Math.sqrt((arousal_tot*arousal_tot)+(valance_tot*valance_tot));
		System.out.println(length);

		// estimate emotion
		double deg=Math.atan2(arousal_tot,valance_tot)*360/(2*Math.PI);
		if(deg<0)
			deg=360+deg;
		
		//double[] difs=new double[7];
		// compute differences
		ArrayList<Double> difs=new ArrayList<Double>();
		int min_idx=0;
		double min_val=400;
		for(int d=0;d<8;d++){
			double cur=Math.abs((double)(d*45)-deg);
			if(cur<min_val){
				min_val=cur;
				min_idx=d;
			}
			//difs.add(Math.abs((double)d-deg));
			//int best=	
		}
		if(360-deg<min_val)
			min_idx=0;
		System.out.println(emotions[min_idx]);
	
	

		

	}
	public static void main(String[] args)
	{
				
		new PicAnalyzer();
	}
}
