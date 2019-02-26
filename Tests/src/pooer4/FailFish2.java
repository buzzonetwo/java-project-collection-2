package pooer4;

public class FailFish2 {

	public static void main(String[] args) {
		Inputter.modInputter();
		int inserter = (Inputter.insert) + 1;
		
		for (int i = 1; i < inserter; i++) {
			printNStars(i);
		}

	}
	
	
	public static void printNStars(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("X");
			
		}
		System.out.println();
	}

}
