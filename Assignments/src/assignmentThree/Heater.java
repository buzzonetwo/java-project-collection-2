package assignmentThree;

public class Heater {

	private int temperature;
	private int min;
	private int max;
	private int increment;
	private String roomname;
	
	public Heater(String input) {
		min = 55;
		max = 85;
		temperature = 70;
		increment = 5;
		roomname = input;
	}
	
	public Heater(String input, int inpmin, int inpmax) {
		min = inpmin;
		max = inpmax;
		temperature = ((min + max) / 2);
		increment = 5;
		roomname = input;
	}

	public void warmer() {
		if (temperature + increment < max) {
			temperature = temperature + increment;
		}
		else {
			temperature = max;
		}
	}
	
	public void cooler() {
		if (temperature - increment > min) {
			temperature = temperature - increment;
		}
		else {
			temperature = min;
		}
	}
	
	public String getName() {
		return roomname;
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public void setTemperature(int input) {
		temperature = input;
	}
	
	public void setIncrement(int input) {
		increment = input;
	}
	
	public String name() {
		return "Andrew Wan";
	}
}
