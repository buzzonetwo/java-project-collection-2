package ctctf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Base64;

public class test {

	
	String crazy;
	
	public test() {
		crazy = "";
	}

	public String input() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("a2.txt"));
			while(scanner.hasNext()){
			   crazy = scanner.next();
			}
					
		} catch (FileNotFoundException f) {
		// TODO Auto-generated catch block
		f.printStackTrace();
		}
		
		return crazy;
	}
	
	public static String rot(String s) {
		String clean = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c) == true) {
            	if (c >= 'a' && c <= 'm'){
            		c += 13;
            	}
            	else if (c >= 'A' && c <= 'M'){
            		c += 13;
            	}
            	else if (c >= 'n' && c <= 'z'){
            		c -= 13;
            	}
            	else if (c >= 'N' && c <= 'Z'){
            		c -= 13;
            	}
            }
            clean = clean + c;
        }
		return clean;
    }

	public static String dec(String s) {
		byte[] bytename = Base64.getDecoder().decode(s);
		String a = new String(bytename);
		return a;
	}
}
