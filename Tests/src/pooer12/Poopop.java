package pooer12;

public class Poopop {

	public static void main(String[] args) {
		PooMatic poox = new PooMatic(6,10);
		int count = 0;
		
		for (int i = 1; i <= 60000; i++) {
			if (poox.pop() == 7) {
				count++;
		
			}
		}
		System.out.println(count);
	}

}
