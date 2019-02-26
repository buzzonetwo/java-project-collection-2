package pooer;

public class PooCounting8 {

	public static void main(String[] args) {
		
		int counter = 0;
		int sum = 0;
		while (counter < 1002)
		{
			if ((counter % 2) == 1)
			{
				sum += counter;
			}
			else
			{
				sum -= counter;
			}
			counter++;
		}
		System.out.print(sum);
	}

}
