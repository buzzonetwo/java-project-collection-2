package pooer10;

public class FlashlightDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flashlight f = new Flashlight();
		for (int i = 1; i <=20; i++) {
			System.out.println(f.getState());
			f.pushButton();
		}
		
		f.replaceBattery();
		System.out.println();
	
	
		for (int i = 1; i <=20; i++) {
			System.out.println(f.getState());
			f.pushButton();
		}
	}
	

}
