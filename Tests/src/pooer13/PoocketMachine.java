package pooer13;

public class PoocketMachine {
	
	private String event;
	private int cap;
	private int left;

	public PoocketMachine(String input, int inp) {
		// TODO Auto-generated constructor stub
		event = input;
		cap = inp;
		left = inp;
	}

	public Poocket issueTicket() {
		if (left > 0) {
			left--;
			Poocket p = new Poocket("Admit one to " + event);
			return p;
		}
		else {
			System.out.print("Fin");
			return null;
		}
	}
	
	public void refill() {
		left = cap;
	}
}
