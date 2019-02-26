package PUDDLE;

public class StringPoo2 {
	private static String st = "computersciencerocks";
	
	public static void main(String[] args) {
		System.out.print(changeToLeet());
	}
	
	public static String changeToLeet() {
		String st2 = st;
		int g = st.length();
		while (g > 0) {
			if (st.substring(g-1,g).equals("e") == true) {
				st2 = st2.substring(0,g-1) + "3" + st2.substring(g,st2.length());
			}
			if (st.substring(g-1,g).equals("t") == true) {
				st2 = st2.substring(0,g-1) + "7" + st2.substring(g,st2.length());
			}
			g--;
		}
		return st2;
	}
}
