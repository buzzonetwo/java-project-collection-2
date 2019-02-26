package g;

public class ok {
	
	public static String stringer = "ddddddwwwwwwaaaaaasssssssssssssseddddddddddddddddddewwawwawwawwawwawwawwaedddssssssddddssssssssewwdwwdwwdwwdwwddssdssdssdssdsswwdwwdwwdwwdwwdwwdwwdassassassassassassassedddddddddddddddewwwwwwwwwwwwwwdssdssdssdssdssdssdsswwwwwwwwwwwwwwssssssssssssssedddddddddddewwwwwwwwwwwwweddddddddddessssssssssssssedddddddewwwwwwwwwwwwwweaaaaaaaedssdssdssdssdssdssdssewdwdwdddwddwdwwddwddwddwddewawwawawaaasasassasssasssdsssdsddsddddwdwwdwwwaaaessdddsddsddddsddddewdwdwdwdwdwdwdwawawawawawawaedddddddddddddddeddddddddaaaaaaaasssssssssssssswwwwwwwwdddddeddddddddeddddddwwwwwwaaaaaassssssssssssssedddddddddddddwwesdsddsdddwddwdwwwawwawawaawaawawwdwwdwdddsddsdsedddwwwdddesssssssssesssssess";
	public static String b = "";
	public static String c = "";
	public static String sly = "";
	public static int count = 0;

	public static void main(String[] args) {
		while (stringer.length() > 1) {
			b = stringer.substring(0, 1);
			c = stringer.substring(1, 2);
			if (b.equals(c)) {
				count++;
			}
			else {
				sly = sly + String.valueOf(count + 1);
				count = 0;
			}
			stringer = stringer.substring(1, stringer.length());
			if (stringer.length() == 1) {
				sly = sly + String.valueOf(count + 1);
			}
			System.out.println(stringer);
			System.out.println(sly);
		}
		System.out.println(sly);
	}

}
