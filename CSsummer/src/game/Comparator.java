package game;

public class Comparator {

	public String answerstring;
	
	public Comparator() {
		answerstring = "";
		
	}
	
	public void changeComparator(int i, int j) {
		if(i < j) {
			answerstring = "You suck. Your guess was lower.";
		}
		else if(i > j) {
			answerstring = "You suck. Your guess was higher.";
		}
		
		else if(i == j) {
			answerstring = "You win.";
		}
		else {
			answerstring = "Write an integer, scrub.";
		}
	}
	
	
	public String getComparator() {
		return answerstring;
	}
	
	
}
