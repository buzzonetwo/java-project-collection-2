package pooer2;

public class Pooing4 {

	public static void main(String[] args) {
		
		int count = 0;
		
		for (int i = 0; i < 600000; i++)
		{
			int randomer = (int) ((Math.random() * 6) + 1);
			int randomer2 = (int) ((Math.random() * 6) + 1);
			
			if ((randomer + randomer2) == 7)
			{
				count++;
			}
		}
		
		System.out.print(count);

	}

}
