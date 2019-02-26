package assignmentEight;

public class TwoDArrayHomework {
	
	private static int[][] a = {{1,2,3},{2,4,6},{3,6,9},{3,2,2}};
	
	/*public static void main(String args[]) {
		printArray();
		System.out.println(evenColumnSum());
		System.out.println(highestColumnAverage());
		System.out.println(sumBorders());
		System.out.println(findMaxInRow(0));
		shrinkArray();
		printArray();
		
	}*/
	
	public static void printArray() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void fillArray(int startvalue) {
		int k = startvalue;
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[j][i] = k;
				k++;
			}
		}
	}
	
	public static int evenColumnSum() {
		int count = 0;
		for (int i = 0; i < a[0].length; i+=2) {
			for (int j = 0; j < a.length; j++) {
				count += a[j][i];
			}
		}
		return count;
	}
	
	public static double highestColumnAverage() {
		double av = 0;
		for (int i = 0; i < a[0].length; i+=2) {
			double count = 0;
			for (int j = 0; j < a.length; j++) {
				count += a[j][i];
			}
			if (count/a.length > av) {
				av = count/a.length;
			}
		}
		return av;
	}
	
	public static int sumBorders() {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (i == 0 || j == 0 || i == a.length-1 || j == a[0].length-1) {
					count += a[i][j];
				}
			}
		}
		return count;
	}
	
	public static void shrinkArray() {
		int b[][] = new int[a.length-2][a[0].length-2];
		for (int i = 1; i < a.length-1; i++) {
			for (int j = 1; j < a[i].length-1; j++) {
				b[i-1][j-1] = a[i][j];
			}
		}
		a = b;
	}
	
	public static int findMaxInRow(int inputrow) {
		int largest = 0;
		for (int j = 0; j < a[0].length; j++) {
			if (a[inputrow][j] > largest) {
				largest = a[inputrow][j];
			}
		}
		return largest;
	}
	
	public static String name() {
		return "Andrew";
	}
}
