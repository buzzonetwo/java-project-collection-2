package PEE;

public class Countdown {

	private SimpleTimer m;
	private SimpleTimer s;
	private boolean hold;
	
	public Countdown(int inm, int ins) {
		m = new SimpleTimer(inm);
		s = new SimpleTimer(ins);
		hold = true;
	}
	
	public void setHold(boolean newHold) {
		hold = newHold;
	}
	
	public void setRemaining(int newMinutes, int newSeconds) {
		m.setValue(newMinutes);
		s.setValue(newSeconds);
	}

	public void timeTick() {
		if (s.getValue() == 0) {
			s.decrement();
			m.decrement();
		}
		else {
			s.decrement();
		}
	}
	
	public void print() {
		if (s.getValue() == 0 && m.getValue() == 0) {
			System.out.println("Liftoff!");
		}
		else {
			System.out.println("T equals minus " + m.getValue() + " minutes and " + s.getValue() + " seconds and counting");
		}
	}
}
