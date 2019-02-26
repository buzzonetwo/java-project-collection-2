package troll;

public class troll {

	public static void main(String[] args) {
		long i = 1000000000L;
		while (i < 10000000000L) {
			boolean p = true;
			int j = 0;
			if ((i/1000000000L)%1 != 0) {
				p = false;
			}
			if ((i/100000000L)%2 != 0) {
				p = false;
			}
			if ((i/10000000L)%3 != 0) {
				p = false;
			}
			if ((i/1000000L)%4 != 0) {
				p = false;
			}
			if ((i/100000L)%5 != 0) {
				p = false;
			}
			if ((i/10000L)%6 != 0) {
				p = false;
			}
			if ((i/1000L)%7 != 0) {
				p = false;
			}
			if ((i/100L)%8 != 0) {
				p = false;
			}
			if ((i/10L)%9 != 0) {
				p = false;
			}
			if ((i/1L)%10 != 0) {
				p = false;
			}

			String k = ((Long) i).toString();
			
			for (int m = 0; m < k.length(); m++) {
				j += Integer.valueOf(k.charAt(m)) - 48;
			}
			
			if (p && j==45) {
				System.out.println(i + " " + j);
			}
			if ((i/100000L)%5 != 0) {
				i += 100000L;
			}
			else {
				i += 10;
			}
		}
		
		
	}

}
