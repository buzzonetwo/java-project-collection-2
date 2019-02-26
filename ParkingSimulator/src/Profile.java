
public class Profile {
	
	private String name;
	private Vehicle vehicle;
	
	public Profile(String s, Vehicle v) {
		this.name = name;
		this.vehicle = vehicle;
	}
	
	public String getname() {
		return name;
	}
	
	public Vehicle getvehicle() {
		return vehicle;
	}
	
	public void setname(String s) {
		name = s;
	}
	
	public void setvehicle(Vehicle v) {
		vehicle = v;
	}
	
	@Override
	public String toString() {
		return name + ", " + vehicle.toString();
		
	}
}
