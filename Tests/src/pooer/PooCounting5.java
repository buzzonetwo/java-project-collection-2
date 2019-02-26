package pooer;

public class PooCounting5 {
	

	public static void main(String[] args) {
		
		int count = 0;
		for (int i = 1; i < 10001; i ++)
		{
			if ((i%7) == 0)
			{
				count++;
			}
		}
		System.out.print(count);
	}
}
