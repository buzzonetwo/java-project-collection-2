package game;


public class Base {
	public static void main(String[] args) {
		
		int counter = 1;
		
		//base
		Guesser pooGuesser = new Guesser();
		Randomizer pooRandomizer = new Randomizer();
		Comparator pooComparator = new Comparator();
		
		
		

		System.out.println("Input an integer from 0 to 100.");
		
		Inputter.modInputter();
		pooGuesser.modGuesser(Inputter.insert);
		
		//compare
		if (pooGuesser.poo >= 0 && pooGuesser.poo <= 100 ) {
			while (pooGuesser.poo != pooRandomizer.randomint) {
				pooComparator.changeComparator(pooGuesser.poo, pooRandomizer.randomint);
				System.out.println(pooComparator.getComparator());
				

				System.out.println("Try again.");
				
				Inputter.modInputter();
				pooGuesser.modGuesser(Inputter.insert);
				
				counter++;
				

			}
			System.out.print("The number was " );
			System.out.print(pooRandomizer.randomint);
			System.out.println(".");
			
			System.out.print("It took you " );
			System.out.print(counter);
			System.out.print(" tries.");
		}
		
	}

	
}
