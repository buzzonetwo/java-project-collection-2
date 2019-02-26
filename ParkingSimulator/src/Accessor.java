//import org.apache.commons.io.FileUtils;


public class Accessor {

	private DList<Database> dblist;
	
	public Accessor(DList<Database> dblist) {
		this.dblist = dblist;
	}
	
	public DList<Database> getdblist() {
		return dblist;
	}

	public void addDB(Database d) {
		dblist.addEnd(d);
	}
}
