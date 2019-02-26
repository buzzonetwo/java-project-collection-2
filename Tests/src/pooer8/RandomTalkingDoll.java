package pooer8;

public class RandomTalkingDoll {
	private String phrase;
	
	public RandomTalkingDoll() {
		if (Math.random() > 0.5) {
			phrase = "Rescue Me";
		}
		else {
			phrase = "Help Me";
		}
	}
	
	public void speak() {
		System.out.println(phrase);
	}
	
}
