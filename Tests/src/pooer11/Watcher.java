package pooer11;

public class Watcher {

	public static void main(String[] args) {
		Watch w = new Watch();

		w.setTime(0,2,3);
		
		for (int i = 1; i < 10; i++) {
			w.Tick();
			w.showTime12();
		}

		
		w.showTime();
	}

}
