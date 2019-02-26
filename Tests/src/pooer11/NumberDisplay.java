package pooer11;

public class NumberDisplay {

	private int x;
	private int maxvalue;
	
	public NumberDisplay(int input) {
		// TODO Auto-generated constructor stub
		x = 0;
		maxvalue = input;
	}
	
	public int getValue() {
		return x;
	}

	public void inc() {
		if (x == maxvalue) {
			x = 0;
		}
		else {
			x++;
		}
	}
}
