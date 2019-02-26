
public class Vehicle {
	
	private String color;
	private String brand;
	private String make;
	private int year;

	public Vehicle(String color, String brand, String make, int year) {
		this.color = color;
		this.brand = brand;
		this.make = make;
		this.year = year;
	}

	@Override
	public String toString() {
		return color + " " + brand + " " + make + " " + String.valueOf(year);
	}
}
