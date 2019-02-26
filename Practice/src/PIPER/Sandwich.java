package PIPER;

public class Sandwich implements MenuItem {
	
	private String name;
	private double price;

	public Sandwich(String inna, double inpr) {
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
