package pooer11;

public class StaplePoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stapler s = new Stapler(100);
		s.refill();
		for (int i = 1; i < 10; i++) {
			s.staple();
		}
		
		Stapler b = new Stapler(344342);
		b.refill(43);
		
	}

}
