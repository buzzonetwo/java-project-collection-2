import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	public static Database createdbfromFile(File f) throws IOException {
		Scanner scanner1 = new Scanner(f);
		
		Database db = new Database(new ArrayList<Profile>(), f.getName());
		
		while (scanner1.hasNext()) {
			String s = scanner1.nextLine();
			System.out.println(s);
			String[] tarray = s.split(",");
			String[] tarray2 = tarray[1].split(" ");
			System.out.println(tarray[0]);
			
			Profile p = new Profile(tarray[0], new Vehicle(tarray2[1],tarray2[2],tarray2[3],Integer.parseInt(tarray2[4])));
			System.out.println(p.getname());
			System.out.println(p.getvehicle().toString());
			
			db.addprofile(p);
			
		}
	
		return db;
		
	}
	
}
