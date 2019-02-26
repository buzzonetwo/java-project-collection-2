package assignmentTwo;

public class StudentTest {

	public static void main(String[] args) {
		/* APstudent Bob = new APstudent("Bob Barker");
		Bob.printStudentData();
		Bob.graduate();
		Bob.newSATScore(1230);
		Bob.printStudentData();
		Bob.graduate();
		Bob.graduate();
		Bob.newSATScore(1130);
		Bob.printStudentData();
		Bob.newSATScore(1890);
		Bob.graduate();
		Bob.graduate();
		Bob.printStudentData(); */
		
		APstudent Joe = new APstudent("Joe Johnson");
		Joe.printStudentData();
		Joe.graduate();
		Joe.newSATScore(1230);
		Joe.printStudentData();
		Joe.graduate();
		Joe.graduate();
		Joe.newSATScore(1130);
		Joe.printStudentData();
		Joe.newSATScore(1890);
		Joe.graduate();
		Joe.graduate();
		Joe.printStudentData(); 
		System.out.println(Joe.name());
	}

}
