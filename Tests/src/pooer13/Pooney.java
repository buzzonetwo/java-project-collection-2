package pooer13;

public class Pooney {

	private double money;
	
	public Pooney(double input) {
		money = input;
	}
	
	public double bankmoney() {
		return money;
	}
	
	public void deposit(double input) {
		money += input;
	}
	
	public void withdraw(double input) {
		if (input <= money) {
			money -= input;
		}
		else {
			money -= input;
			money -= 10.0;
		}
	}
	
}

