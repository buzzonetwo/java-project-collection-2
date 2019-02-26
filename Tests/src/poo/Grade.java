package poo;


public class Grade {

	
	
	public static void main(String[] args) {
		Inputter.modInputter();	
		Grader grades = new Grader(Inputter.insert);
		System.out.println(grades.getGrade());
	}

}
