package ctctf;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;



public class encode {
	
	

	public static void main(String[] args) {
		
		test f = new test();
		String x = f.input();

		try {
			PrintWriter writer = new PrintWriter("result2.txt", "UTF-8");
		
			for (int i = 0; i < 14; i++) {
				x = test.rot(x);
				x = test.dec(x);
				writer.println(x);
				writer.println();
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
