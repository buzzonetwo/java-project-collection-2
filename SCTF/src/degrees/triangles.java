package degrees;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class triangles {

	public static void main(String args[]) {
		try {
			PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
			int count = 0;
			for (int i = 1; i < 3179; i++) {
				count+=i;
				writer.print(count);
				writer.print(" ");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
