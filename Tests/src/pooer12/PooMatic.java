package pooer12;

public class PooMatic {

	private Poodie a;
	private Poodie b;
	
	
	public PooMatic(int inp, int inp2) {
		a = new Poodie(inp);
		b = new Poodie(inp2);
	}
	
	public int pop() {
		return a.roll() + b.roll();
	}
	

}
