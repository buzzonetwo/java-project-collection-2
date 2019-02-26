package pooer5;

public class PooX {
	
	
	public static void main(String[] args) {
		System.out.print(weirdAdd(1001));
		
	}
	
	public static int SumUpTo(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		return sum;
	}
	
	public static int Divisibleby7(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (i%7 == 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int CountHeads(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int random = (int) ((Math.random() * 2));
			if (random == 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int addEvens(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i+=2) {
			sum = sum + i;
		}
		return sum;
	}
	
	public static int weirdAdd(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			if (i%2 == 1) {
				sum = sum + i;
			}
			else {
				sum = sum - i;
			}
		}
		return sum;
	}
	
}
