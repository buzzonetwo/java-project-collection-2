package POO;

public class POOO {
 
	public static void main(String[] args) {
		// printMultsofFive2(54);
		// System.out.print(diceCount(20000,100));
		System.out.print(sumEvens(10,19));
	}
	
	
	public static int doMathOn(int x, int y) {
		if (x > y) {
			return ((x * x) - y);
		}
		else {
			return ((y * y) - x);
		}
	}
	
	public static void printMultsofFive(int n) {
		for (int i = 0; i < n; n+=5) {
			System.out.print(n + " ");
		}
	}
	
	public static void printMultsofFive2(int n) {
		
		int poo = n;
		while ((poo%5) != 0) {
			poo--;
		}
		
		for (int i = poo; i > 0; i-=5) {
			System.out.print(i + " ");
		}
	}
	
	public static int diceCount(int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			int randomer = (int) (Math.random()*20);
			
			if (randomer == 0) {
				count++;
			}
		
		}
		return count;
		
	}
	
	public static int diceCount(int n, int sides) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			int randomer = (int) (Math.random()*sides);
			
			if (randomer == 0) {
				count++;
			}
		
		}
		return count;
		
	}
	
	public static int sumEvens(int start, int stop) {
		int sum = 0;
		if ((start % 2) == 1) {
			start++;
		}
		for (int i = start; i <= stop; i+=2) {
			sum += i;
		}
		return sum;
	}
	
}
