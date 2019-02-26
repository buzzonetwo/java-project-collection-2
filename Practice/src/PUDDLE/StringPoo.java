package PUDDLE;

public class StringPoo {
	public static void main4(String[] args) {
		String st = "abcdefghi";
		st = st.substring(1,st.length()) + st.substring(0,1) + "ay";
		System.out.println(st);
	}
	
	public static void main(String[] args) {
		String st = "abcdefghi";
		int x = st.indexOf("e");
		st = st.substring(0,x) + st.substring(x+1,st.length());
		System.out.println(st);
	}
	
	public static void main3(String[] args) {
		String st = "abcdefghi";
		int x = st.length(); 
		if (x % 2 == 1) {
			st = st.substring(0,x/2) + st.substring(x/2+1,st.length());
		}
		System.out.println(st);
	}
}
