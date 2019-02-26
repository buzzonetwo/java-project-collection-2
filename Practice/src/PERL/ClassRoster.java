package PERL;

import java.util.*;

public class ClassRoster
{
    // INSTANCE VARIABLES
    private String teacher;
    private Student[] students;
    
    //  CONSTRUCTOR
    public ClassRoster(String inputteacher, int numberofstudents)
    {
        teacher = inputteacher;
        students = new Student[numberofstudents];
        Scanner scan = new Scanner(System.in);
        for (int index=0; index<students.length; index++)
        {
            System.out.print("Enter name of student #" + (index+1) + "-->");
            String name = scan.next();
            System.out.print("Enter number of grades of student #" + (index+1) + "-->");
            int grades = scan.nextInt();
            System.out.print("What kind of student?  Enter H for honors, R for regular-->");
            String type = scan.next();
            if (type.equals("H"))
            {
                students[index] = new HonorsStudent(name, grades);
            }
            else
            {
                students[index] = new RegularStudent(name, grades);
            }
        }
    } 

    //  METHODS (You will write these)
    public int numberOfAStudents()
    {
    	int count = 0;
    	for (int i = 0; i < students.length; i++) {
    		if (students[i].computeGPA() > 3.5) {
    			count++;
    		}
    	}
        return count;
    }
    
    public ArrayList<String> failingStudents()
    {
    	ArrayList<String> poop = new ArrayList<String>();
    	for (int i = 0; i < students.length; i++) {
    		if (students[i].computeGPA() < 2.0) {
    			poop.add(students[i].getName());
    		}
    	} 
        return poop;
    }
    
    public double computeClassGPA()
    {
    	double sum = 0;
    	for (int i = 0; i < students.length; i++) {
    		sum += students[i].computeGPA();
    	}
        return sum/students.length;
    }
    
    public Student bestStudent()
    {
    	int x = 0;
    	for (int i = 0; i < students.length; i++) {
    		if (students[i].computeGPA() > students[x].computeGPA()) {
    			x = i;
    		}
    	} 
        return students[x];
    }
    
    public void printClassInfo()
    {
    	System.out.println(teacher + "'s class");
    	for (int i = 0; i < students.length; i++) {
    		System.out.println(students[i].getName() + " GPA: " + String.format("%.3g", students[i].computeGPA()));
    	}
    	System.out.println("Average GPA: " +  String.format("%.3g",computeClassGPA()));
    }
    
    public String myName()   
    {
        return "Andrew";     // Replace with your own name
    }
}