package pooer9;

public class CountingTalkingDoll {

	private String phrase;
	private int timesspoken;
	
	public CountingTalkingDoll() {
		phrase = "Rescue Me";
		timesspoken = 0;
	}
	
	public void speak() {
		System.out.println(phrase);
		timesspoken++;
	}
	
	public void changePhrase(String inputphrase) {
		phrase = inputphrase;
	}
	
	public int getTimesSpoken() {
		return timesspoken;
	}

}
