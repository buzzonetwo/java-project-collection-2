package degrees;
import java.util.Scanner;
public class Deadfish
{
	public static void main(String args[])
	{
		Scanner comm = new Scanner(System.in);
		boolean isSquared = false;
		int x = 0;
		String usrinput;
		while(true)
		{
			System.out.print(">> ");
			usrinput = comm.next();
			if(usrinput.contentEquals("i"))
			{
				if(x >= 256 && isSquared == false)
					x = 0;
				x++;
			}
			else if(usrinput.contentEquals("d"))
			{
				if(x <= -1 && isSquared == false)
					x = 0;
				x--;
			}
			else if(usrinput.contentEquals("o"))
				System.out.println(x);
			else if(usrinput.contentEquals("s"))
			{
				if(x >= 256)
					isSquared = true;
				x = x * x;
			}
			else
				System.out.println();
			System.out.println(x);
		}
	}
}
