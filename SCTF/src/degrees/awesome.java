package degrees;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class awesome {

	
	
	public static void main(String[] args) {
		Scanner scanner;
		Scanner scanner2;
		try {
			scanner = new Scanner(new File("the-file-name.txt"));
			int[] tall = new int[3178];
			int m = 0;
			while(scanner.hasNextInt()){
			   tall[m++] = scanner.nextInt();
			}
			
			scanner2 = new Scanner(new File("fullinput.txt"));
			int[] taller = new int[100000];
			int n = 0;
			while(scanner2.hasNextInt()){
			   taller[n++] = scanner2.nextInt();
			}
			
			try {
				PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
				int count = 0;
				for (int l = 0; l < taller.length; l++) {
					int local = taller[l];
					boolean adder = false;
					int j = 0;
					while (tall[j] < local) {
						int k = 0;
						while (tall[k] < local) {
							if (tall[j] + tall[k] == local) {
								adder = true;
							}
							writer.print(local);
							writer.print(" ");
							writer.print(tall[j]);
							writer.print(" ");
							writer.print(tall[k]);
							writer.print(" ");
							writer.print(tall[j]+tall[k]);
							writer.print(" ");

							writer.println(adder);
							k++;
							if (adder == true) {
								local = 0;
							}
						}
						j++;
					}
					if (adder == true) {
						count++;
					}
				}
				writer.println(count);
				writer.close();
				System.out.println(count);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
