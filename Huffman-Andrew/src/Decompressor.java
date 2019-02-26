import java.io.File;
import java.util.BitSet;
import java.util.HashMap;
import java.nio.file.Files;

public class Decompressor {
	
	private byte[] filebytes;
	
	private String pls;

	public Decompressor(File f) {
		try {
			filebytes = Files.readAllBytes(f.toPath());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String stringEncoded() {
		String s = "";
		BitSet b = BitSet.valueOf(filebytes);
		for (int i = 0; i < b.length(); i++) {
			if (b.get(i)) {
				s += "1";
			}
			else {
				s += "0";
			}
		}
		
		
		return s;
	
	}
	
	public HNode toptree() {
		pls = stringEncoded();
		HNode top = new HNode(0);
		pls = pls.substring(1);
		treechanger(top);
		return top;
	}
	
	public void treechanger(HNode h) {
		if (h.left == null) {
			if (pls.charAt(0) == '0') {
				HNode h2 = new HNode(0);
				h.left = h2;
				pls = pls.substring(1);
				treechanger(h2);
			}
			else if (pls.charAt(0) == '1') {
				String str = pls.substring(1, 9);
				HNode h2 = new HNode(Character.toString((char) Integer.parseUnsignedInt(str, 2)).charAt(0),0);
				h.left = h2;
				pls = pls.substring(9);
			}
		}
		if (h.right == null){
			if (pls.charAt(0) == '0') {
				HNode h2 = new HNode(0);
				h.right = h2;
				pls = pls.substring(1);
				treechanger(h2);
			}
			else if (pls.charAt(0) == '1') {
				String str = pls.substring(1, 9);
				HNode h2 = new HNode(Character.toString((char) Integer.parseUnsignedInt(str, 2)).charAt(0),0);
				h.right = h2;
				pls = pls.substring(9);
			}
		}
	}
		/**
		 * Returns a hashmap that contains the characters of the string 
		 * and the string encoded compressed equivalents
		 * @return a hashmap that contains the characters of the string 
		 * and the string encoded compressed equivalents
		 */
		public HashMap<String, Character> tableMap() {
			HashMap<String, Character> m = new HashMap<String, Character>();
			mapHelp(m, toptree(), "");
			return m;
			
		}
		
		private void mapHelp(HashMap<String, Character> m, HNode h, String s) {
			if (h.left.check) {
				mapHelp(m, h.left, s+"0");
			}
			else {
				m.put(s+"0",h.left.c);
			}
			if (h.right.check) {
				mapHelp(m, h.right, s+"1");
			}
			else {
				m.put(s+"1",h.right.c);
			}
		}
	
		public String decode() {
			tableMap();
			String str = "";
			String temp = pls;
			HashMap<String, Character> hm = tableMap();
			System.out.println(hm);
			System.out.println(pls);
			boolean terminate = true;
			
			while (temp.length() > 0 && terminate) {
				try {
				for (int i = 0; i < hm.size(); i++) {
					if (hm.containsKey(temp.substring(0, i+1))) {
						if (hm.get(temp.substring(0, i+1)).equals('\u0004')) {
							terminate = false;
							break;
						}
						str += hm.get(temp.substring(0, i+1));
						temp = temp.substring(i+1);
						break;
					}
				}
				}
				catch (Exception e) {
					temp += "0";
				}
			}
			return str;
		}
}
