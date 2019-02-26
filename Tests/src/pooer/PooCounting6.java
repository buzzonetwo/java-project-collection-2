package pooer;

public class PooCounting6 {
	
	
	public static void main(String[] args) 
	{
		int count = 0;
		for (int i = 1; i < 100001; i++)
		{
			int randomer = (int) (Math.random() * 2);
			if (randomer == 0)
			{
				count++;
			}
		}
		System.out.println(count + " Heads");
		System.out.print((100000 - count) + " Tails");
	
	}
}
