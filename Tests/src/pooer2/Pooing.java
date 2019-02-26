package pooer2;

public class Pooing {
	
	public static void main(String[] args) {
	
		int pos = 5;
		
		for (int i = 0; i < 50; i++)
		{
			int randomer = (int) (Math.random() * 3);
			if (randomer == 0)
			{
				pos++;
			}
			else if (randomer == 1)
			{
				pos--;
			}
			
			
			for (int k = 0; k < pos; k++)
			{
				System.out.print(" ");
			}
			System.out.println("X");
			
		}

	}

}
