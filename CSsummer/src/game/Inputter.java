package game;


import java.util.InputMismatchException;
import java.util.Scanner;


public class Inputter {
	
	public static int insert = -1;
	private static Scanner scan;

	

	public static void modInputter() {
		scan = new Scanner(System.in);
		try {
			insert = scan.nextInt();
		} catch (InputMismatchException e) { 
			System.out.println("Input a integer, idiot! \nYou killed the program!");
			
		}
		

	}
}
