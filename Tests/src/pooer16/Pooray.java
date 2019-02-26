package pooer16;

public class Pooray {

	private static int[] a = {584343,4535,33433,43253,4323,45233};
	
	
	public static void main(String[] args) {
		printBackwards();
		System.out.println(findSum());
		System.out.println(smallestElement());
		System.out.println(allGreaterThan(1000));
		System.out.println(countNumberOf(453));

	}

	public static void printBackwards() {
		for (int i = (a.length - 1); i > -1; i--) {
			System.out.println(a[i]);
		}
	}
	
	public static int findSum() {
		int x = 0;
		for (int i = (a.length - 1); i > -1; i--) {
			x += a[i];
		}
		return x;
	}
	
	public static int smallestElement() {
		int x = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < x) {
				x = a[i];
			}
		}
		return x;
	}
	
	public static boolean allGreaterThan(int x) {
		boolean s = true;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= x) {
				s = false;
			}
		}
		return s;
	}
	
	public static int countNumberOf(int x) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				s += 1;
			}
		}
		return s;	
	}	
	
}
