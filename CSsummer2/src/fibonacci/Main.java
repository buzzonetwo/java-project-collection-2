package fibonacci;

public class Main {

	public static void main(String[] args) {
		
		
		Addition pooAdder = new Addition();

		System.out.println("Input an integer from 0 to 100.");
		Inputter.modInputter();

		if (Inputter.insert > 0) {
			
			System.out.print("Fibonacci #");
			System.out.print((Inputter.insert));
			System.out.print(" is ");
			System.out.print(pooAdder.Adder(Inputter.insert));
		}
	}

}
