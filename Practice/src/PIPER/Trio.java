	package PIPER;

public class Trio implements MenuItem {
	
	private String name;
	private double price;

	public Trio(Sandwich sa, Salad sl, Drink dr) {
		name = sa.getName() + "/" + sl.getName() + "/" + dr.getName();
		if (sa.getPrice() <= sl.getPrice() && sa.getPrice() <= dr.getPrice()) {
			price = sl.getPrice() + dr.getPrice();
		}
		else if (sl.getPrice() <= sa.getPrice() && sl.getPrice() <= dr.getPrice()) {
			price = sa.getPrice() + dr.getPrice();
		}
		else {
			price = sl.getPrice() + sa.getPrice();
		}
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
