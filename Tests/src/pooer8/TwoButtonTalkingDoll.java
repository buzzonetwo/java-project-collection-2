package pooer8;

public class TwoButtonTalkingDoll {
	
	private String phraseone;
	private String phrasetwo;

	public TwoButtonTalkingDoll() {
		phraseone = "poo";
		phrasetwo = "pee";
	}

	public void speakone() {
		System.out.println(phraseone);
	}
	public void speaktwo() {
		System.out.println(phrasetwo);
	}
}
