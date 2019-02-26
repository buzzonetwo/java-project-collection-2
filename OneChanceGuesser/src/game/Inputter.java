package game;


import java.util.InputMismatchException;
import java.util.Scanner;


public class Inputter {
	
	public static int insert;
	private static Scanner scan;

	

	public static void modInputter() {
		System.out.println("Input an integer from 0 to 10.");
		scan = new Scanner(System.in);
		try {
			insert = scan.nextInt();
		} catch (InputMismatchException e) { 
			System.out.println("Input a integer, idiot!");
		}
		

	}
}
