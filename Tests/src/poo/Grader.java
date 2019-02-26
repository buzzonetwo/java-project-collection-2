package poo;

public class Grader {
	
	public String shownGrade;
	
	public Grader() {
		shownGrade = "No grade";
	}
	
	public Grader(int pooer) {
		if (pooer > 90) {
			shownGrade = "A";
		}
		else if (pooer > 80) {
			shownGrade = "B";
		}
		else if (pooer > 70) {
			shownGrade = "C";
		}
		else if (pooer > 60) {
			shownGrade = "D";
		}
		else {
			shownGrade = "F";
		}
	}
	
	public String getGrade() {
		return shownGrade;
	}


}
