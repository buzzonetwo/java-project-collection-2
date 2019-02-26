package pooer9;

public class DollDriver {

	public static void main(String[] args) {
		CountingTalkingDoll mydoll = new CountingTalkingDoll();
		mydoll.speak();
		mydoll.changePhrase("Poo");
		mydoll.speak();
		System.out.println(mydoll.getTimesSpoken());
	}
}
