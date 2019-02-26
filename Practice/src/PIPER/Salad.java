package PIPER;

public class Salad implements MenuItem {
	
	private String name;
	private double price;

	public Salad(String inna, double inpr) {
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
