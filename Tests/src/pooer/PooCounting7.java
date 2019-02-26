package pooer;

public class PooCounting7 {

	public static void main(String[] args) 
	{
		int counter = 0;
		int sum = 0;
		while (counter < 1001)
		{
			sum += counter;
			counter++;
		}
		System.out.print(sum);
	}
}
