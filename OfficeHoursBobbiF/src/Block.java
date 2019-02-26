
public class Block {
	
	private String name;//this is the actual block i.e. A,B,C,D etc.
	private String day;//day that the block is on
	
	private linkedlist<teacher> teachers;//teachers free that block
	
	public Block (String name)
	{
		this.name = name;
		teachers = new linkedlist<teacher>();
	}
	/**
	 * adds teacher to ll
	 */	
	public void addTeachers(teacher inputteacher)
	{
		teachers.add(inputteacher);
	}
	
	/**
	 * @return teacher with certain name
	 */
	public teacher getTeacher(String tn)
	{
		for (int i = 0; i < teachers.getLength(); i++)
		{
			String name = teachers.getNodeData(i).getName();
			if (tn.equals(name))
			{
				return teachers.getNodeData(i);
			}
		}
		
		return null;
	}
	
	public void setName(String inputname)
	{
		name = inputname;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDay()
	{
		return day;
	}
	
	public void setDay(String d)
	{
		day = d; 
	}
	
	public linkedlist<teacher> getTeachers()
	{
		return teachers;
	}
	
	/**
	 * removes teacher from ll once student signs up for them
	 */
	public void removeTeacher(int i)
	{
		linkedlist<teacher> n = new linkedlist<teacher>();
		if (teachers.getLength() == 1)
		{
			teachers = n;

		}
		else
		{
			teachers.removeNode(i);
		}
		
	}
	
}