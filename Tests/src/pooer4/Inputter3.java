package pooer4;

import java.util.*;

public class Inputter3 {
	
	public static int insert = -1;
	private static Scanner scan;

	

	public static void modInputter() {
		System.out.println("Input a number to print odd numbers until");
		scan = new Scanner(System.in);
		try {
			insert = scan.nextInt();
		} catch (InputMismatchException e) { 
			System.out.println("Input a integer, idiot! \nYou killed the program!");
			
		}
		

	}
}
