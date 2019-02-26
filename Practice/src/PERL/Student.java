package PERL;

import java.util.Scanner;

public abstract class Student
{
    //  INSTANCE VARIABLES
    private String lastname;
    private String[] grades;   // Each grade is a String, "A" through "F"

    //  CONSTRUCTOR
    public Student(String inputname, int howmanygrades)
    {
        lastname = inputname;
        grades = new String[howmanygrades];
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<grades.length; i++)
        {
            System.out.print("Enter grade #" + (i+1) + "-->");
            String thegrade = scan.next();
            grades[i] = thegrade;
        }
    }
            
    //  METHODS (You will write these)
    public String getName()
    {
        return lastname;
    }
    
    public void changeName(String newname)
    {
    	lastname = newname;
    }
    
    public int numberOfGrades()
    {
    	return grades.length;
    }
    
    public void printAllGrades()
    {
    	//local
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	int d = 0;
    	int f = 0;
    	for (int i = 0; i < grades.length; i++) {
    		if (grades[i].equals("A") == true) {
    			a++;
    		}
    		else if (grades[i].equals("B") == true) {
    			b++;
    		}
    		else if (grades[i].equals("C") == true) {
    			c++;
    		}
    		else if (grades[i].equals("D") == true) {
    			d++;
    		}
    		else if (grades[i].equals("F") == true) {
    			f++;
    		}
    	}
    	System.out.print(a + "As, " + b + "Bs, " + c + "Cs, " + d + "Ds, " + f + "Fs");
    }
    
    public double convertGradeToDouble(String inputgrade)
    {
    	if (inputgrade.equals("A") == true) {
			return 4.0;
		}
		else if (inputgrade.equals("B") == true) {
			return 3.0;
		}
		else if (inputgrade.equals("C") == true) {
			return 2.0;
		}
		else if (inputgrade.equals("D") == true) {
			return 1.0;
		}
		else if (inputgrade.equals("F") == true) {
			return 0.0;
		}
		else {
			return (Double) null;
		}
    }
    
    public double sumOfGrades()
    {
    	double sum = 0;
    	for (int i = 0; i < grades.length; i++) {
    		sum += convertGradeToDouble(grades[i]);
    	}
    	return sum;
    }
 
    public String lowestGrade()
    {
    	String str = "A";
    	for (int i = 0; i < grades.length; i++) {
    		if (str.compareTo(grades[i]) < 0) {
    			str = grades[i];
    		}
    	}
    	return str;
    }
    
    
    public abstract double computeGPA();
   
    
    public String myName()
    {
        return "Andrew";     // Replace with your name
    }
}
