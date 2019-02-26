import java.util.ArrayList;


public class Database {

	private ArrayList<Profile> data;
	private String dbname;
	
	public Database(ArrayList<Profile> data, String dbname) {
		this.data = data;
		this.dbname = dbname;
	}
	
	public ArrayList<Profile> getdata() {
		return data;
	}
	
	public String getdbname() {
		return dbname;
	}
	
	public void setdbname(String s) {
		dbname = s;
	}
	
	public void addprofile(Profile p) {
		data.add(p);
	}
	
	@Override
	public String toString() {
		String s = dbname;
		for (int i = 0; i < data.size(); i++) {
			dbname += data.get(i).toString();
		}
		return s;
	}
	
	
}
