package pooer2;

public class Pooing2 {

	public static void main(String[] args) {
		
		int limit = 100;
		int counter = 0;
		int max = 0;
		while (counter < limit)
		{
			int randomer = (int) (Math.random() * 1000000);
			if (randomer > max)
			{
				max = randomer;
			}
			counter++;
		}
		System.out.print(max);
	}
}
