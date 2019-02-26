package pooer3;

import java.util.*;

public class Inputter {
	
	public static int insert = -1;
	private static Scanner scan;

	

	public static void modInputter() {
		System.out.println("Input case");
		scan = new Scanner(System.in);
		try {
			insert = scan.nextInt();
		} catch (InputMismatchException e) { 
			System.out.println("Input a integer, idiot! \nYou killed the program!");
			
		}
		

	}
}
