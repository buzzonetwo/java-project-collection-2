import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import java.util.HashMap;

public class Compressor {

	private String s;
	
	/**
	 * Creates a new compressor with a given string
	 * @param str string to be compressed
	 */
	public Compressor(String str) {
		s = str;
	}
		
	/**
	 * Creates a hashmap of the characters in the string and the frequencies of the characters
	 * @return a hashmap of the characters in the string and the frequencies of the characters
	 */
	public HashMap<Character, Integer> chars() {
		HashMap<Character, Integer> hash = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (hash.containsKey(s.charAt(i))) {
				hash.replace(s.charAt(i), (hash.get(s.charAt(i))+1));
			}
			else {
				hash.put(s.charAt(i), 1);
			}
		}
		return hash;
	}

	/**Returns the Priority Queue for the given hashmap
	 * @return a priority queue
	 */
	public PriorityQueue<HNode> getPQueue() {
		Character[] mapped = chars().keySet().toArray(new Character[0]);
		PriorityQueue<HNode> queued = new PriorityQueue<HNode>();
		for (int i = 0; i < mapped.length; i++) {
			HNode h = new HNode(mapped[i], chars().remove(mapped[i]));
			queued.add(h);
		}
		return queued;
	}
	
	/**
	 * Returns a reference to a node that has the frequency with the length of the string 
	 * and is at the top of a Huffman tree with left and right references
	 * @return a reference to a node that has the frequency with the length of the string 
	 * and is at the top of a Huffman tree 
	 */
	private HNode top() {
		PriorityQueue<HNode> q = getPQueue();
		while (q.size() > 1) {
			combine(q);
		}
		return q.remove();
	}
	
	private PriorityQueue<HNode> combine(PriorityQueue<HNode> q) {
		HNode a = q.remove();
		HNode b = q.remove();
		HNode c = new HNode(a.freq+b.freq);
		c.left = a;
		c.right = b;
		q.add(c);
		return q;
	}
	
	/**
	 * Returns a hashmap that contains the characters of the string 
	 * and the string encoded compressed equivalents
	 * @return a hashmap that contains the characters of the string 
	 * and the string encoded compressed equivalents
	 */
	public HashMap<Character, String> tableMap() {
		HashMap<Character, String> m = new HashMap<Character, String>();
		mapHelp(m, top(), "");
		return m;
		
	}
	
	private void mapHelp(HashMap<Character, String> m, HNode h, String s) {
		if (h.left.check) {
			mapHelp(m,h.left,(s+"0"));
		}
		else {
			m.put(h.left.c, s+"0");
		}
		if (h.right.check) {
			mapHelp(m,h.right,(s+"1"));
		}
		else {
			m.put(h.right.c, s+"1");
		}
	}

	
	public HashMap<Character, BitSet> tableMap2() {
		HashMap<Character, BitSet> m = new HashMap<Character, BitSet>();
		mapHelp2(m, top(), new BitSet());
		return m;
	}
	
	private void mapHelp2(HashMap<Character, BitSet> m, HNode h, BitSet s) {
		if (h.left.check) {
			BitSet s2 = s;
			s2.set(s.length(), false);
			mapHelp2(m,h.left,s2);
		}
		else {
			BitSet s2 = s;
			s2.set(s.length(), false);
			m.put(h.left.c, s2);
		}
		if (h.right.check) {
			BitSet s2 = s;
			s2.set(s.length(), true);
			mapHelp2(m,h.right,s2);
		}
		else {
			BitSet s2 = s;
			s2.set(s.length(), true);
			m.put(h.right.c, s2);
		}
	}
	
	public String encodedTableString() {
		String str = "";
		str = encodedTableStringHelp(str,top());
		return str;
	}
	
	private String encodedTableStringHelp(String ts, HNode h) {
		//HashMap<Character, String> localmap = tableMap();
		if (h.check) {
			ts = ts + "0";
			ts = encodedTableStringHelp(ts, h.left);
			ts = encodedTableStringHelp(ts, h.right);
		}
		else {
			ts = ts + "1";
			int a = Character.valueOf(h.c);
			String s = Integer.toBinaryString(a);
			final int LENGTH = 8;
			while (s.length() < LENGTH) {
				s = "0" + s;
			}
			ts = ts + s;
		}
		return ts;
	}
	
	public byte[] encodedTableBytes() throws UnsupportedEncodingException {
		byte[] valuesAscii = encodedTableString().getBytes("US-ASCII");
		for (int i = 0; i < valuesAscii.length; i++) {
			valuesAscii[i] = (byte) (valuesAscii[i] - 48);
		}
		BitSet b = new BitSet(8);
		for (int i = valuesAscii.length - 1; i > -1; i--) {
			if (valuesAscii[i] == 1) {
				b.set(i, true);
			}
			else {
				b.set(i, false);
			}
		}
		byte[] outarray = b.toByteArray();
		return outarray;
	}
	
	public String encodedStringString() {
		HashMap<Character, String> map = tableMap();
		String newstr = "";
		for (int i = 0; i < s.length(); i++) {
			newstr = newstr + map.get(s.charAt(i));
		}
		return newstr;
	}
	
	public byte[] encodedStringBytes() throws UnsupportedEncodingException {
		byte[] valuesAscii = encodedStringString().getBytes("US-ASCII");
		for (int i = 0; i < valuesAscii.length; i++) {
			valuesAscii[i] = (byte) (valuesAscii[i] - 48);
		}
		BitSet b = new BitSet(8);
		for (int i = valuesAscii.length - 1; i > -1; i--) {
			if (valuesAscii[i] == 1) {
				b.set(i, true);
			}
			else {
				b.set(i, false);
			}
		}

		byte[] outarray = b.toByteArray();
		return outarray;
	}
	public byte[] encodedFullBytes() throws UnsupportedEncodingException {
		byte[] valuesAscii = (encodedTableString() + encodedStringString()).getBytes("US-ASCII");
		for (int i = 0; i < valuesAscii.length; i++) {
			valuesAscii[i] = (byte) (valuesAscii[i] - 48);
		}
		BitSet b = new BitSet(8);
		for (int i = valuesAscii.length - 1; i > -1; i--) {
			if (valuesAscii[i] == 1) {
				b.set(i, true);
			}
			else {
				b.set(i, false);
			}
		}

		byte[] outarray = b.toByteArray();
		return outarray;
	}

	
}
