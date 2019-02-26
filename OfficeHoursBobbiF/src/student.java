
public class student {

	private String name;
	private String block;//block the student signed up for 
	private String day;//day the student signed up for
	
	public student(String n, String b, String d)
	{
		name = n;
		block = b;
		day = d;
	}
	
	public void setBlockDay(String b, String d)
	{
		block = b;
		day = d;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDay()
	{
		return day;
	}
	
	public String getBlock()
	{
		return block;
	}
}
