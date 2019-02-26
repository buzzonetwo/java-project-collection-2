package pooer14;

public class Pooghasihgdsiua {
	
	public static void main(String args[]) {
		generateKey();
	}

	public static void generateKey() {
        int i = 1;
        int x = 181;
        int n = 5493;
        while (i <= 25) {
            x = (x * i) % n;
            i++;
        }
        System.out.print("flag_" + Math.abs(x));
    }

}
