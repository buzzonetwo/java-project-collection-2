
public class tester {

	public static void main(String[] args) {
		String s = "Bob Dylan, red Toyota Camry 2000";

		

		String[] tarray = s.split(",");
		String[] tarray2 = tarray[1].split(" ");
		System.out.println(tarray[0]);
		System.out.println(tarray[1]);
		System.out.println(tarray2[0]);
		System.out.println(tarray2[1]);
		System.out.println(tarray2[2]);
		System.out.println(tarray2[3]);
		System.out.println(tarray2[4]);

	}

}
