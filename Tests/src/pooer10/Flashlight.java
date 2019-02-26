package pooer10;

public class Flashlight {
	
	private String onoff;
	private int batteryleft;

	public Flashlight() {
		// TODO Auto-generated constructor stub
		onoff = "Off";
		batteryleft = 5;
	}
	
	public void pushButton() {
		if (onoff.equals("Off") && batteryleft > 0) {
			onoff = "On";
			batteryleft--;
		}
		else {
			onoff = "Off";
		}
	}
	
	public String getState() {
		return onoff;
	}
	
	public void replaceBattery() {
		batteryleft = 5;
	}

}
