package PISSY;

public class stupido {

	public static void main(String args[]) {
		printNum(5);
	}

	public static void printNum(int x) {
		for (int i = x; i > 0; i--) {
			System.out.println();
			for (int j = i; j > 0; j--) {
				System.out.print(j);;
			}
		}
	}
}