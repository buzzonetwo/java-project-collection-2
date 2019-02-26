package pooer11;

public class Die {

	private int sides;
	private int timesrolled;
	
	public Die(int input) {
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
