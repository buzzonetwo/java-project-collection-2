package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class ds {

	public static void main(String[] args) {
		Scanner inputter = new Scanner(System.in);
		BigInteger pole1 = new BigInteger(inputter.nextLine());
		ArrayList<BigInteger> diskValues1 = Main.readSavedPoleInformation(pole1);
		
		BigInteger flag = Main.createSavedPoleInformation(diskValues1); 			
		System.out.println("YOU WIN!");
		System.out.println("Your flag is: " + flag);
	}

}
