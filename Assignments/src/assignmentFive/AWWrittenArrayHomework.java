package assignmentFive;

public class AWWrittenArrayHomework {
	
	private static int[] a = {0, 1, 3, 44, 11, 18, 43, 1};

	public static void printArray() {
		// TODO Auto-generated method stub
		for (int i: a) {
			System.out.print(i + " ");
		}
	}
	
	public static void printArray(int[] x) {
		// TODO Auto-generated method stub
		for (int i: x) {
			System.out.print(i + " ");
		}
	}
	
	public static int addElementsFrom(int index) {
		int x = 0;
		for (int i = index; i < a.length; i++) {
			x += a[i];
		}
		return x;
	}
	
	public static double average() {
		int x = addElementsFrom(0);
		return ((double) x / a.length);
	}

	public static int countEvens() {
		int x = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				x++;
			}
		}
		return x;
	}
	
	public static int largestElement() {
		int x = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > x) {
				x = a[i];
			}
		}
		return x;
	}
	
	public static boolean isItThere(int input) {
		boolean x = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == input) {
				x = true;
			}
		}
		return x;
		
	}
	
	public static int alternateSum() {
		int x = 0;
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				x += a[i];
			}
			else {
				x -= a[i];
			}
		}
		return x;
		
	}
	
	public static boolean isOrdered() {
		boolean x = true;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i-1]) {
				x = false;
			}
		}
		return x;
		
	}
	
	public static void reverseMe() {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[a.length-i-1];
		}
		a = b;
		
	}
	
	public static void rotateMe() {
		int[] b = new int[a.length];
		for (int i = 1; i < a.length; i++) {
			b[i] = a[i-1];
		}
		b[0] = a[a.length-1];
		a = b;
	}
	
	public static boolean areThereDuplicates() {
		boolean x = false;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					x = true;
				}		
			}
		}
		return x;
	}
	
	public static String name() {
		return "Andrew";
	}
}
