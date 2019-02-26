package pooer8;

public class TwoPhraseTalkingDoll {
	private String phrase;
	private static int timesTalked = 0;
	
	public TwoPhraseTalkingDoll() {
		
	}
	
	public void speak() {
		if (timesTalked == 0) {
			phrase = "Rescue Me";
		}
		else if (timesTalked == 1){
			phrase = "Help Me";
		}
		else {
			phrase = "Save Me";
					
		}
		System.out.println(phrase);
		timesTalked++;
		if (timesTalked == 2) {
			timesTalked = -1;
		}
	}
}
