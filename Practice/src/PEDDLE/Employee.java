package PEDDLE;

public class Employee {

	private int age;
	private int yearsonjob;
	private double salary;
	
	public Employee(int x, int y, double z) {
		age = x;
		yearsonjob = y;
		salary = z;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getYearsOnJob() {
		return yearsonjob;
	}
	
	public double getSalary() {
		return salary;
	}

}
