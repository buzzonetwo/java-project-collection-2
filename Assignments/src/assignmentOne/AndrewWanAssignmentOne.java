package assignmentOne;

public class AndrewWanAssignmentOne {
	
	public static void main(String[] args) {
		
	}
	

	
	
	public static int largest(int x, int y) {
		if (x > y) {
			return x;
		}
		else {
			return y;
		}	
	}
	
	public static int smallest(int x, int y) {
		if (x > y) {
			return y;
		}
		else {
			return x;
		}	
	}
	
	public static int smallest(int x, int y, int z) {
		return smallest(smallest(x,y),z);
		
	}
	
	public static String typeOfTriangle(int x, int y, int z) {
		
	
		int small = smallest(x,y,z);
		int large = largest(largest(x,y),z);
		int middle;
		
		if (small == large) {
			middle = small;
		}
		else if (x == y || x == z || y == z) {
			if (x == y) {
				middle = x;
			}
			else if (x == z) {
				middle = x;
			}
			else {
				middle = y;
			}
		}
		else {
			if (x != large && x!= small) {
				middle = x;
			}
			else if (y != large && y!= small) {
				middle = y;
			}
			else {
				middle = z;
			}
		}
		
		
		
		if (x == y && y == z) {
			return "Equilateral";
		}
		else if (x == y || x == z || y == z) {
			return "Isosceles";
		}
		else if (small + middle > large) {
			return "Scalene";
		}
		else {
			return "No triangle possible";
		}
	}
	
	public static String yourGrade(int testone, int testtwo, int testthree) {
		double average = (testone + testtwo + testthree) / 3.0;
		
		if (average >= 90.0) {
			return "A";
		}
		else if (average >= 80.0) {
			return "B";
		}
		else if (average >= 70.0) {
			return "C";
		}
		else if (average >= 60.0) {
			return "D";
		}
		else {
			return "F";
		}
	}
	
	public static String yourAdjustedGrade(int testone, int testtwo, int testthree) {
		double average = (testone + testtwo + testthree - smallest(testone,testtwo,testthree)) / 2.0;
		
		if (average >= 90.0) {
			return "A";
		}
		else if (average >= 80.0) {
			return "B";
		}
		else if (average >= 70.0) {
			return "C";
		}
		else if (average >= 60.0) {
			return "D";
		}
		else {
			return "F";
		}
	}
	
	public static void printFence(int posts) {
		
		System.out.print("|");
		for (int i = 1; i < posts; i++) {
			System.out.print("--|");
		}
		System.out.println();
	}
	
	public static void printWeirdFences(int posts) {
		for (int i = posts; i > 1; i--) {
			printFence(i);
		}
	}
	
	public static boolean isPrime(int value) {
		int switcher = 0;
		while (switcher == 0)
		{
			for (int i = 2; i < value; i++)
			{
				if ((value % i) == 0)
				{
					switcher = 1;
				}
			}
			if (switcher != 1)
			{
				switcher = 2;
			}
		}
		
		if (switcher == 1)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}


	
	
}
