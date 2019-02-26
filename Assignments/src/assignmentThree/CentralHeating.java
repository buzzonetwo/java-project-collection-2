package assignmentThree;

public class CentralHeating {
	
	private Heater heaterone;
	private Heater heatertwo;

	public CentralHeating(String nameo, String namep) {
		heaterone = new Heater(nameo);
		heatertwo = new Heater(namep);
	}
	
	public void incrementOne() {
		heaterone.warmer();
	}
	
	public void incrementTwo() {
		heatertwo.warmer();
	}
	
	public void decrementOne() {
		heaterone.cooler();
	}
	
	public void decrementTwo() {
		heatertwo.cooler();
	}
	
	public void printHeaterInfo() {
		System.out.println(heaterone.getName() + ": " + heaterone.getTemperature() + "  " + heatertwo.getName() + ": " + heatertwo.getTemperature());
	}
	
	public void average() {
		int x = (heaterone.getTemperature() + heatertwo.getTemperature()) / 2;
		heaterone.setTemperature(x);
		heatertwo.setTemperature(x);
	}
	
	public void changeIncrement(int input) {
		heaterone.setIncrement(input);
		heatertwo.setIncrement(input);
	}
	
	public String hottestRoom() {
		if (heaterone.getTemperature() > heatertwo.getTemperature()) {
			return heaterone.getName();
		}
		else {
			return heatertwo.getName();
		}

	}
	
	public String name() {
		return "Andrew";
	}

}
