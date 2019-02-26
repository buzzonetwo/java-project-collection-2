package PIPER;

public class Drink implements MenuItem {
	
	private String name;
	private double price;

	public Drink(String inna, double inpr) {
		name = inna;
		price = inpr;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
