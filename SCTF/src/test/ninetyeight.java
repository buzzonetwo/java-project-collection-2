package test;

public class ninetyeight {

	public static void main(String[] args) {
		int x = 0;
		for (int i = 0; i < 8; i++) {
			x*=7;
			x+=98;
			System.out.print(x%256);
			System.out.print(" ");
			System.out.println(x);
		}

	}

}
