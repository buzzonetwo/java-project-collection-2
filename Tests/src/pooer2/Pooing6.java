package pooer2;

public class Pooing6 {

	public static void main(String[] args) {
		
		int roller1;
		int roller2;
		int roller3;
		int roller4;
		
		int limiter = 1;
		int counter = 0;
		int limit = 100000;

		while (limiter < (limit + 1))
		{
			roller1 = (int) ((Math.random() * 6) + 1);
			roller2 = (int) ((Math.random() * 6) + 1);
			roller3 = (int) ((Math.random() * 6) + 1);
			roller4 = (int) ((Math.random() * 6) + 1);
			
			System.out.println(roller1 + " " + roller2 + " " + roller3 + " " + roller4);
			
			if ((roller2 > roller1) && (roller3 > roller2) && (roller4 > roller3))
			{
				counter++;
			}
			limiter++;
		}
		
		System.out.print(counter + " games won out of " + limit + " games played");

	}

}
