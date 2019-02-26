package pooer11;

import java.util.Scanner;

public class DiePoo {

	public static void main(String[] args) {
		
		while (true) { 		
			Die d = new Die(100000);
			while (d.roll() != 1) {
			}
			System.out.println(d.getTimesRolled());
		}
	}

}
