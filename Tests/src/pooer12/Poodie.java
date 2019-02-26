package pooer12;

public class Poodie {

	private int sides;
	private int timesrolled;
	
	public Poodie(int input) {
		// TODO Auto-generated constructor stub
		sides = input;
		timesrolled = 0;
	}
	
	public int roll() {
		timesrolled++;
		return (int) (Math.random() * sides) + 1;
	}

	public int getTimesRolled() {
		return timesrolled;
	}

}
