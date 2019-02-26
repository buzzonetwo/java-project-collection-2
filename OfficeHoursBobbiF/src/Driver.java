import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Driver{

	
	public static void main(String [] args)
	{	
		Driver d = new Driver();
		Logic l = new Logic ();
		d.fillFile(l);
		d.runGUI(l);
	}

	/**
	 * writes to file
	 */
	public void fillFile(Logic l)
	{
		ArrayList<String> rawFileData = new ArrayList<String>();

		File file = new File("OfficeHoursData.txt");

		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine())
			{
				String line = sc.nextLine();
				rawFileData.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String day;
		String block;
		String [] teachers;
		String line;
		String [] lineData = new String [3];


		if (!rawFileData.isEmpty())
		{
			for (int i = 0; i < rawFileData.size(); i++)
			{
				line = rawFileData.get(i);
				
				lineData = line.split(":");
				
				if( lineData.length == 3 ) {
					day = lineData[0];
					block = lineData[1];
					
					teachers = lineData[2].split(",");

					for (int j = 0; j < teachers.length; j++)
					{
						l.populate(day, block, teachers[j]);
					}
				}
				
			}
		}
	}

	public void runGUI(Logic l)
	{
		boolean isTeacher = false;

		String [] options = {"Teacher", "Student"};

		String message = "Student or Teacher?";

		int n = JOptionPane.showOptionDialog(null, message, "Office Hours", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

		if (n == JOptionPane.CLOSED_OPTION)
		{
			System.exit(-1);
		}

		if (n == 0)
		{
			isTeacher = true;
		}

		if (isTeacher)
		{
			TeacherBox t = new TeacherBox(l);
		}

		else
		{
			StudentGUI s = new StudentGUI(l);
		}
	}


}


