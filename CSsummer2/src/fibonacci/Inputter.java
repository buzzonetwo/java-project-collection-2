package fibonacci;

import java.util.*;

public class Inputter {
	
	public static long insert = -1;
	private static Scanner scan;

	

	public static void modInputter() {
		scan = new Scanner(System.in);
		try {
			insert = scan.nextLong();
		} catch (InputMismatchException e) { 
			System.out.println("Input a integer, idiot! \nYou killed the program!");
			
		}
		

	}
}
