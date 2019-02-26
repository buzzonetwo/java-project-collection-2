package game;


public class Base {
	public static void main(String[] args) {
		
		//base
		Guesser pooGuesser = new Guesser();
		Randomizer pooRandomizer = new Randomizer();
		Comparator pooComparator = new Comparator();
		
		
		//unnecessary steps
		Inputter.modInputter();
		pooGuesser.modGuesser(Inputter.insert);
		
		//compare
		if (pooGuesser.poo >= 0 && pooGuesser.poo <= 10 ) {
			pooComparator.changeComparator(pooGuesser.poo, pooRandomizer.randomint);
		
			System.out.println(pooComparator.getComparator());
			System.out.print("The number was " );
			System.out.print(pooRandomizer.randomint);
			System.out.print(".");
		}
		
	}

	
}
