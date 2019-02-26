package pooer2;

public class Pooing5 {

	public static void main(String[] args) {
		
		int limiter = 1;
		String flipper = " ";
		
		int counter = 0;
		int maxcounter = 0;
		
		while (limiter < 1000001)
		{
			
			int randomer = (int) ((Math.random() * 2) + 1);
			
			String oldflipper = flipper;
			
			if (randomer == 1)
			{
				flipper = "T";
			}
			else 
			{
				flipper = "H";
			}
			
			if (maxcounter < counter)
			{
				maxcounter = counter;
			}
			
			if (oldflipper == flipper)
			{
				counter++;
			}
			else
			{
				counter = 0;
			}
			
		
			
			
			
			
			
			limiter++;
		}
		System.out.print(maxcounter);
	}
}
