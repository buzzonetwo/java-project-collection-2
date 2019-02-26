package PEE;

public class SimpleTimer {

	private int cur;
	private int max;
	
	public SimpleTimer(int newLimit) {
		cur = newLimit;
		max = newLimit;
	}
	
	public int getLimit() {
		return max;
	}
	
	public int getValue() {
		return cur;
	}
	
	public void setValue(int newValue) {
		if (newValue > 0) {
			cur = newValue;
		}
		else {
			cur = max;
		}
	}
	
	public void decrement() {
		cur -= 1;
		if (cur < 0) {
			cur = max;
		}
	}
}
