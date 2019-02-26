package assignmentTwo;

public class APstudent {
	
	private String stname;
	private String stgrade;
	private int stsat; 

	//Andrew
	public APstudent(String name) {
		// TODO Auto-generated constructor stub
		stname = name;
		stgrade = "Freshman";
		stsat = 0;
	}
	
	public String getName() {
		return stname;
	}

	public String getGrade() {
		return stgrade;
	}
	
	public int highestSAT() {
		return stsat;
	}
	
	public void printStudentData() {
		
		String pjsat;
		
		if (stsat == 0) {
			pjsat = " and has not taken the SAT";
		}
		else {
			pjsat = " with best SAT score " + stsat;
		}
		
		
		System.out.println("Student " + stname + " is a " + stgrade + pjsat);
	}
	
	public void graduate() {
		if (stgrade.equals("Freshman")) {
			stgrade = "Sophomore";
		}
		else if (stgrade.equals("Sophomore")) {
			stgrade = "Junior";
		}
		else if (stgrade.equals("Junior")) {
			stgrade = "Senior";
		}
		else if (stgrade.equals("Senior")) {
			stgrade = "Alumni";
		}
		else {
			stgrade = "Alumni";
		}
	}
	
	public void newSATScore(int inputscore) {
		if (inputscore > stsat) {
			stsat = inputscore;
		}
	}
	
	
	public String name() {
		return "Andrew Wan";
	}
}
