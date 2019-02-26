package g;

public class rip {

	public static void main(String[] args) {
		long i = 1;
		long j = 0;
		long c = 10000000000L;
		while (recur(i)+1<c) {
			j += recur(i);
			System.out.println(recur(i));
			i++;
		}
		System.out.println(j);
	}

	public static long recur(long i) {
		if (i > 2) {
			return (6*recur(i-1)-recur(i-2)+2);
		}
		else if (i == 1) {
			return 3;
		}
		else if (i == 2) {
			return 20;
		}
		else {
			return 0;
		}
		
		
	}
}
