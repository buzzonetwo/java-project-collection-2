package PEDDLE;

import java.util.ArrayList;

public class Company {

	private int retireage;
	private int retireyears;
	private double retiresalary;
	
	private ArrayList<Employee> myEmployees;
	private double myTotalSalary;
	
	public Company(int x, int y, double z, double aa) {
		retireage = x;
		retireyears = y;
		retiresalary = z;
		myTotalSalary = aa;
		myEmployees = new ArrayList<Employee>();
		// TODO Auto-generated constructor stub
	}
	
	private boolean employeeIsEligible(Employee emp) {
		if (emp.getAge() >= retireage && emp.getYearsOnJob() >= retireyears && emp.getSalary() >= retiresalary) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void processRetirements() {
		for (int i = 0; i < myEmployees.size(); i++) {
			if (employeeIsEligible(myEmployees.get(i)) == true) {
				myTotalSalary = myTotalSalary - myEmployees.get(i).getSalary();
				myEmployees.remove(i);
			}
		}
	}
	
	public int oldestAge() {
		int old = 0;
		for (int i = 0; i < myEmployees.size(); i++) {
			if (myEmployees.get(i).getAge() > old) {
				old = myEmployees.get(i).getAge();
			}
		}
		return old;
	}
	
	

}
