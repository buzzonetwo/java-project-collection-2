package pooer;

public class PooCounting {
	
	public static void main(String[] args)
	{
		int count = 0;
		for (int i = 0; i < 6000000; i++)
		{
			int randomer = (int) (Math.random()*6) + 1;
			if (randomer == 6)
			{
				count++;
			}
		}
		System.out.println(count);
	}
}
