package fibonacci;


public class Addition {
	
	public long temp1 = 0;
	public long temp2 = 1;
	public long sum;
	
	
	public Addition() {
		sum = 0;
	}
	
	
	public long Adder(long num) {
		
		for (long i = (num - 1); i > 0; i--) {
			sum = temp2 + temp1;
			temp1 = temp2;
			temp2 = sum;
		}
		
		return sum;
	}


	
	
}
