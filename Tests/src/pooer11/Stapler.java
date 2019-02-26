package pooer11;



public class Stapler {

	private int capacity;
	private int numberleft;
	
	public Stapler(int inputcapacity) {
		// TODO Auto-generated constructor stub
		capacity = inputcapacity;
		numberleft = 0;
	}

	public void staple() {
		if (numberleft == 0) {
			System.out.println("No staples");
		}
		else {
			System.out.println("stapled");
			numberleft--;
		}
	}
	
	public void refill() {
		numberleft = capacity;
	}
	
	public void refill(int inputnum) {
		
		if (numberleft + inputnum >  capacity){
			System.out.println("not possible");
		}
		else {
			numberleft += inputnum;
		}
	}
	
	public int seeStaples() {
		return numberleft;
	}
}
