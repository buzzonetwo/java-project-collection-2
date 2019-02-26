package degrees;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class awesome2 {

	
	
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
				PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
				PrintWriter writer2 = new PrintWriter("progress.txt", "UTF-8");

				int j = 0;
				while (j < tall.length) {
					int k = j;
					while (k < tall.length) {
						if ((tall[j] + tall[k] < 5060000) && lister.lastIndexOf((tall[j] + tall[k])) < 0) {
							lister.add(tall[j] + tall[k]);
							writer2.print(lister.size());
							writer2.print(" ");
							writer2.print(tall[j]);
							writer2.print(" ");
							writer2.print(tall[k]);
							writer2.print(" ");
							writer2.println(tall[j] + tall[k]);
						}
						if (tall[j] + tall[k] > 5060000) {
							 k = 5000;
						}
						k++;
					}
					j++;
				}
				for (int x = 0; x < lister.size(); x++) {
					writer.println(lister.get(x));
				}
				writer.close(); 
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
