package pooer7;

public class StPoo {
	
	public static void main(String[] args){
		System.out.print(numofFlips(10));
	}

	public static void printupTo(int n) {
		for (int i = 1;  i <= n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void printPattern(int n) {
		for (int i = 1;  i <= n; i++) {
			printupTo(i);
		}
	}
	
	public static void printPattern2(int n) {
		for (int i = n;  i > 0; i--) {
			printupTo(i);
		}
	}
	
	public static int square(int n) {
		return n * n;
	}
	
	public static int sumFirstSquares(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += square(i);
		}
		return sum;
		
	}
	
	public static int numofHeads(int n) {
		int counter = n;
		int sum = 0;
		while (counter != 0) {
			int coin = (int) (Math.random() * 2);
			if (coin == 0) {
				sum++;				
			}
			counter--;
		}
		return sum;
	}
	
	public static int numofFlips(int n) {
		int counter = 0;
		int sum = 0;
		while (sum != n) {
			if (Math.random() > 0.5) {
				sum++;				
			}
			counter++;
		}
		return counter;
	}
}
