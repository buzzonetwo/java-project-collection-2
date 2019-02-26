package flufferduff;

import java.util.InputMismatchException;
import java.util.Scanner;

public class duffer {

	public static void main(String args[]) {
		int counter = 0;
		for (int i = 1; i < 1000; i++) {
			if (underPrimeSum(i) - underOddSum(i) < 0) {
				counter++;
			}
			
			System.out.print(underPrimeSum(i));
			System.out.print(" ");
			System.out.print(underOddSum(i));
			System.out.print(" ");
			System.out.println(underPrimeSum(i) - underOddSum(i));
		}
		System.out.print(counter);
	}

	public static boolean primer(int insert) {
				
		int switcher = 0;
		boolean trick = false;
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
		
		if (switcher == 1 && insert != 2)
		{
			trick = false;
		}
		else 
		{
			trick = true;
		}
		return trick;
	}
	
	public static int underPrimeSum(int x) {
		int count = 0;
		for (int i = 2; i < x; i++) {
			if (primer(i) == true) {
				count += i;
			}
		}
		return count;
	}
	
	public static int underOddSum(int x) {
	/*	int count = 0;
		for (int i = 1; i < x; i++) {
			if (i%2 != 0) {
				count += i;
			}
		}
		return count;
	*/
		return (x/2)*(x/2);
	}

	
}


