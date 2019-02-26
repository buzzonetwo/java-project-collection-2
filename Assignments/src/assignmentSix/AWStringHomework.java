package assignmentSix;

public class AWStringHomework {
	public static String st = "gooby";
	
	/* public static void main(String[] args) {
		System.out.println(removeLettersBetween("a","e"));
		printPattern();
		System.out.println(doubleLetter());
		System.out.println(repeatString((8)));
		System.out.println(makePalindrome());
	} */
	
	public static String removeLettersBetween(String one, String two) {
		String c = st;
		int i = 0; 
		while (i < c.length()) {
			if (c.substring(i,i+1).compareTo(one) >= 0 && c.substring(i,i+1).compareTo(two) <= 0) {
				c = c.substring(0,i) + c.substring(i+1,c.length());
			}
			else {
				i++;
			}
		}
		return c; 
	} 
	
	public static boolean doubleLetter() {
		boolean c = false;
		for (int i = 0; i < st.length()-1; i++) {
			if (st.substring(i,i+1).equals(st.substring(i+1,i+2)) == true) {
				c = true;
			}
		}
		return c;
	}
	
	public static void printPattern() {
		String c = st;
		int i = 0; 
		while (i < c.length()) {
			System.out.println(c.substring(i));
			i++;
		}
	}
	
	public static String repeatString(int num) {
		String c = st;
		int i = num - 1; 
		while (i > 0) {
			c = c + st;
			i--;
		}
		return c;
	}
	
	public static String makePalindrome() {
		String c1 = "";
		String c2 = "";
		for (int i = st.length(); i > 0; i--) {
			c1 = c1 + st.substring(i-1,i);
		}
		c2 = st + c1;
		return c2;
		
	}
}
