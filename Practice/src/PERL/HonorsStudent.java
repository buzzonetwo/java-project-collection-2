package PERL;

public class HonorsStudent extends Student
{
	//  No extra instance variables

	//  The constructor is necessary, even though you just use super
	public HonorsStudent(String inputname, int howmanygrades)
	{
		super(inputname, howmanygrades);
	}
	
	//  Code for the method computeGPA, which is abstract in Student
	public double computeGPA()
	{
	    return sumOfGrades()/numberOfGrades();
	}
}