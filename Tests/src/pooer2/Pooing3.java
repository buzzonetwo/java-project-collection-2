package pooer2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pooing3 {

	public static void main(String[] args) {
		
		int insert = 0;
		Scanner scan;
		scan = new Scanner(System.in);
		
		int switcher = 0;
		
		try {
			insert = scan.nextInt();
		} catch (InputMismatchException e) { 
			System.out.println("Input a integer, idiot! \nYou killed the program!");
		}
		
		while (switcher == 0)
		{
			for (int i = 2; i < insert; i++)
			{
				if ((insert % i) == 0)
				{
					switcher = 1;
				}
			}
			if (switcher != 1)
			{
				switcher = 2;
			}
		}
		
		if (switcher == 1)
		{
			System.out.print("Not Prime");
		}
		else if (switcher == 2)
		{
			System.out.print("Prime");
		}
	}

}
