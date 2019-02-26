public class HNode implements Comparable<HNode>{

	char c;
	int freq;
	HNode left;
	HNode right;
	boolean check;
	
	/**
	 * The constructor with a character will be noted 
	 * as having no children with the boolean check
	 * @param ch the unicode character
	 * @param i the frequency
	 */
	public HNode(char ch, int i) {
		// TODO Auto-generated constructor stub
		c = ch;
		freq = i;
		check = false;
	}
	
	/**
	 * The constructor without a character will be noted 
	 * as having children with the boolean check
	 * @param i the frequency
	 */
	public HNode(int i) {
		freq = i;
		check = true;
	}
	
	/**
	 * Compares frequency 
	 */
	public int compareTo(HNode o) {
		if (o.freq < freq) {
			return -1;
		}
		else if (o.freq > freq) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return c + " = " + freq;
		
	}
	
}
