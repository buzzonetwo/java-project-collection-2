package degrees;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class awesome3 {

	
	
	public static void main(String[] args) {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("the-file-name.txt"));
			int[] tall = new int[3178];
			int m = 0;
			while(scanner.hasNextInt()){
			   tall[m++] = scanner.nextInt();
			}
			
			ArrayList<Integer> lister = new ArrayList<Integer>();
			
			try {
				PrintWriter writer2 = new PrintWriter("output.txt", "UTF-8");

				int j = 0;
				while (j < tall.length) {
					int k = j;
					while (k < tall.length) {
						if ((tall[j] + tall[k] < 5060000) && lister.lastIndexOf((tall[j] + tall[k])) < 0) {
							lister.add(tall[j] + tall[k]);
							writer2.println(tall[j] + tall[k]);
						}
						if (tall[j] + tall[k] > 5060000) {
							 k = 5000;
						}
						k++;
					}
					j++;
				}
				 
				writer2.close();
				System.out.println(lister.size());
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
