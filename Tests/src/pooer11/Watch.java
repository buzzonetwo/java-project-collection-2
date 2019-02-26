package pooer11;

public class Watch {

	private NumberDisplay h;
	private NumberDisplay m;
	private NumberDisplay s;
	
	public Watch() {
		h = new NumberDisplay(23);
		m = new NumberDisplay(59);
		s = new NumberDisplay(59);
	}
	
	public void showTime() {
		System.out.print(h.getValue() + ":");
		if (m.getValue() < 10) {
			System.out.print("0" + m.getValue() + ":");
		}
		else {
			System.out.print(m.getValue() + ":");
		}
		if (s.getValue() < 10) {
			System.out.println("0" + s.getValue());
		}
		else {
			System.out.println(s.getValue());
		}
	}
	
	public void showTime12() {
		String mer;
		if (h.getValue() < 12 && h.getValue() > 0) {
			System.out.print(h.getValue() + ":");
			mer = "AM";
		}
		else if (h.getValue() == 0) {
			System.out.print(12 + ":");
			mer = "AM";
		}
		else {
			if (h.getValue() == 12) {
				System.out.print("12" + ":");
				mer = "PM";
			}
			else {
				System.out.print((h.getValue()-12) + ":");
				mer = "PM";
			}	
		}
		
		
		if (m.getValue() < 10) {
			System.out.print("0" + m.getValue() + ":");
		}
		else {
			System.out.print(m.getValue() + ":");
		}
		if (s.getValue() < 10) {
			System.out.print("0" + s.getValue());
		}
		else {
			System.out.print(s.getValue());
		}
		System.out.println(" " + mer);
	}
	
	public void Tick() {
		s.inc();
		if (s.getValue() == 0) {
			m.inc();
		}
		if (m.getValue() == 0 && s.getValue() == 0) {
			h.inc();
		}
	}
	
	public void setTime(int hx, int mx, int sx) {

		while (h.getValue() != hx) {
			h.inc();
		}
		
		while (m.getValue() != mx) {
			m.inc();
		}
		
		while (s.getValue() != sx) {
			s.inc();
		}
	}
}

