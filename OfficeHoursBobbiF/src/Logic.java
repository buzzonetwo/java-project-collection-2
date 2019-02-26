import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Logic {

	private Block[][] allblocks;
	private ArrayList<String> newData;
	private ArrayList<Block> teacherfreeblocks;

	
	/**
	* creates 2d array which is internal storage
	*/

	public Logic()
	{

		String [] monday = {"A", "B", "C", "D", "Lunch", "E", "F", "G"};
		String [] tuesday = {"B", "C", "D", "E", "Lunch", "F", "G", "A"};
		String [] wednesday = {"A1", "A2", "B1", "B2", "Lunch", "C1", "C2", "D1", "D2"};
		String [] thursday = {"G1", "G2", "F1", "F2", "Lunch", "E1", "E2"};
		String [] friday = {"D", "E", "F", "Lunch", "G", "A", "B", "C"};


		Block[] Monday = new Block[8];
		for (int i = 0; i< Monday.length; i++)
		{
			Block b = new Block(monday[i]);
			Monday[i] = b;
			b.setDay("Monday");
		}
		Block[] Tuesday = new Block[8];
		for (int i = 0; i< Tuesday.length; i++)
		{
			Block b = new Block(tuesday[i]);
			Tuesday[i] = b;
			b.setDay("Tuesday");
		}
		Block[] Wednesday = new Block[9];
		for (int i = 0; i< Wednesday.length; i++)
		{
			Block b = new Block(wednesday[i]);
			Wednesday[i] = b;
			b.setDay("Wednesday");
		}
		Block[] Thursday = new Block[7];
		for (int i = 0; i< Thursday.length; i++)
		{
			Block b = new Block(thursday[i]);
			Thursday[i] = b;
			b.setDay("Thursday");
		}
		Block[] Friday = new Block[8];
		for (int i = 0; i< Friday.length; i++)
		{
			Block b = new Block(friday[i]);
			Friday[i] = b;
			b.setDay("Friday");
		}


		allblocks = new Block[5][];
		allblocks[0] = Monday;
		allblocks[1] = Tuesday;
		allblocks[2] = Wednesday;
		allblocks[3] = Thursday;
		allblocks[4] = Friday;
	}

	public void addTeacherData (String tn, ArrayList<String> day, ArrayList<String> block)
	{		
		//this method is comprised of Mr. Sea's code
		teacher t = new teacher(tn);
		String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday"};

		for (int i = 0; i<day.size();i++)
		{
			String d = day.get(i);
			String b = block.get(i);
		
				for (int j = 0; j<days.length; j++)
				{
					if (d.equals(days[j]))
					{
						Block[] blocks = allblocks[j];
						
						for (int k = 0; k < blocks.length; k++)
						{
							if(b.equals(blocks[k].getName()))
							{
								allblocks[j][k].addTeachers(t);
							}
							
						}
					}
					
				}

		}

		updateFile();

	}

	public void addStudentData(student s, String tn)
	{		
			String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday"};

			String d = s.getDay();
						
			String b = s.getBlock();
		
				for (int j = 0; j<days.length; j++)
				{
					
					
					if (d.equals(days[j]))
					{
						Block[] blocks = allblocks[j];
						
						for (int k = 0; k < blocks.length; k++)
						{
							if(b.equals(blocks[k].getName()))
							{
								linkedlist<teacher> t = allblocks[j][k].getTeachers();
								
								for (int l = 0; l < t.getLength(); l++)
								{
									if (tn.equals(t.getNodeData(l).getName()))
									{
										allblocks[j][k].removeTeacher(l);

									}
								}
							}
							
						}
					}
					
				}
		
		updateFile();
	}

	public ArrayList<Block> sortThroughTeachers(String teachername)
	{
		ArrayList<Block> b = new ArrayList<Block>();

		for (int i=0; i<allblocks.length;i++)
		{
			for (int j = 0; j<allblocks[i].length;j++)
			{
				linkedlist<teacher> t = allblocks[i][j].getTeachers();
				for (int r = 0; r<t.getLength();r++)
				{
					if (t.getNodeData(r).getName().equals(teachername))
					{
						b.add(allblocks[i][j]);
					}
				}
			}
		}
		
		teacherfreeblocks = b;
		
		return b;
	}

	public void updateFile()
	{
		ArrayList<String> newData;

		File file = new File("OfficeHoursData.txt");

		newData = new ArrayList<String>();

		for (int i = 0; i < 40; i++)
		{
			newData.add(sendBlockData().get(i));
		}

		try {

			PrintWriter output = new PrintWriter(file);

			for (int i = 0; i < newData.size(); i++)

			{

				output.println(newData.get(i));

			}

			output.close();

		} catch (FileNotFoundException e1) {

			// TODO Auto-generated catch block

			e1.printStackTrace();

		}

	}

	public void populate(String day, String block, String teach ) {
		
		// method written by Mr. Sea
		String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

		String [] monday = {"A", "B", "C", "D", "Lunch", "E", "F", "G"};
		String [] tuesday = {"B", "C", "D", "E", "Lunch", "F", "G", "A"};
		String [] wednesday = {"A1", "A2", "B1", "B2", "Lunch", "C1", "C2", "D1", "D2"};
		String [] thursday = {"G1", "G2", "F1", "F2", "Lunch", "E1", "E2"};
		String [] friday = {"D", "E", "F", "Lunch", "G", "A", "B", "C"};
		String[][] allblocks = { monday, tuesday, wednesday, thursday, friday };

		int dayNum = 0;
		for( String d : days ) {
			if( !day.equals(d) ) {
				dayNum++;
			}
			else {
				break;
			}
		}

		String[] dayblocks = allblocks[dayNum];
		int blockNum = 0;
		for( String s : dayblocks ){
			if( !block.equals(s) ) {
				blockNum++;
			}
			else {
				break;
			}
		}

		teacher t = new teacher(teach);
		
		this.allblocks[dayNum][blockNum].addTeachers(t);
	}

	public ArrayList<String> sendBlockData()
	{
		ArrayList<String> data = new ArrayList<String>();
		Block b;
		String teachers;
		
		for (int i = 0; i < allblocks.length; i++)
		{
			Block [] curr = allblocks[i];

			for (int j = 0; j < curr.length; j++)
			{
				b = curr[j];

				teachers = "";

				for (int k = 1; k <= b.getTeachers().getLength(); k++)
				{
					if (k == (b.getTeachers().getLength()))
					{
						teachers = teachers + b.getTeachers().getNodeData(k).getName();
						
						
					}
					else
					{
						teachers = teachers + b.getTeachers().getNodeData(k).getName() + ",";
						
						
					}
				}

				String s = b.getDay() + ":" + b.getName() + ":" + teachers;
				
				data.add(s);
			}
		}

		return data;
	}

}



