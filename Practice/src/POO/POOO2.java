package POO;

public class POOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printFirstNSquaresOpp(10);
		// printSquaresUpTo(25);
		System.out.print(nearOneHundred(111));
		
	}
	
	public static void printFirstNSquares(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(i*i + " ");
		}
	}
	
	public static void printFirstNSquaresOpp(int n) {
		for (int i = n; i > 0; i--) {
			System.out.print(i*i + " ");
		}
	}
	
	public static void printSquaresUpTo(int n) {
		int counter = 2;
		int square = 1;
		while (square <= n) {
			
			System.out.print(square + " ");
			square = counter * counter;
			counter++;
		}
	}
	
	public static boolean nearOneHundred(int n) {
		if (Math.abs(100 - n) < 11) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public static String lessOrMore(int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (int)(Math.random() * 6) + 1;
		}
		sum = sum / n;
		if (sum > 3.5) {
			return "More";
		}
		else {
			return "Less";
		}
		
	}
	
}
