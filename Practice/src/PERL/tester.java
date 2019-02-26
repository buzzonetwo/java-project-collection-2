package PERL;

public class tester {

	public static void main(String[] args) {

		ClassRoster c = new ClassRoster("Mr.Poop", 2);
		System.out.println(c.numberOfAStudents());
		System.out.println(c.bestStudent().getName());
		System.out.println(c.failingStudents().toString());
		c.printClassInfo();
		System.out.println(c.myName());

		
		
	}

}
