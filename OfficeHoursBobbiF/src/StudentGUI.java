import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentListener;
public class StudentGUI {

	private String studentname;
	private String selectedBlock;
	private String selectedTeacher;
	private String selectedDay;
	
	private ArrayList<JButton> blockButtons;
	
	private Logic l;
	
	JComboBox teacherbox;
	
	JButton filter;
	
	public StudentGUI(Logic logic)
	{
		l = logic;
		
		studentname = JOptionPane.showInputDialog("Enter your name.");
		
		while (studentname.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid name.");
			studentname = JOptionPane.showInputDialog("Enter your name.");
		}
		
		if (studentname == null)
		{
			System.exit(-1);
		}
		
		
		JFrame f = new JFrame("Office Hours (Student)");
		BorderLayout fl = new BorderLayout();
		f.setLayout(fl);
		f.setSize(800,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel(); 
		GridBagLayout bl = new GridBagLayout();
		p.setLayout(bl);

		JPanel r = new JPanel();
		GridLayout gl = new GridLayout(3,1);
		r.setLayout(gl);
				
		teacherbox = new JComboBox();
		teacherbox.setToolTipText("Choose Teacher");
		r.add(teacherbox);
		teacherbox.addActionListener(new JComboBoxListener());
		
		filter = new JButton("Filter");
		filter.addActionListener(new FilterListener());
		filter.setBackground(new Color(59, 89, 182));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		p.add(r, gbc);

		gbc.gridheight = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.insets = new Insets(100,0, 0, 0);
		p.add(filter, gbc);

		//sets up jcombobox
		String [] teachers = {"Select Teacher", "Andy", "Madam Bordet", "Dr. Brakeman", "Corey", "Mr. Correa", "Ms. Diaz", "Dr. Enelow", "Ms. Fahey", "Fern", "Ms. Galligan", "Ms. Glogover", "Ms. Guergue", "Mr. Harper", "Ms. Kaplan", "Dr. Kinney", "Dr. Lisowski", "Mrs. Mckenna", "Dr. Bradley", "Mr. Clark", "Mr. Davies", "Mr. Evans", "Ms. Feidelman", "Matt Fraser", "Mr. Guzman", "Ms. Krier", "Mrs. Miller", "Mr. Muniz", "Naoko", "Ms. Nguyen", "Ms. Pryor", "Ms. Ray", "Ms. Sanker", "Mr. Schneider", "Mr. Sea", "Ms. Temple", "Mr. Tower", "Ms. V", "Mr. Wells", "Ms. Yee", "Ms. Sarkar", "Mr. Scott", "Ms. Tang", "Mr. Vann", "Mr. Von K", "Ms. Wu"};
		teacherbox.setModel(new DefaultComboBoxModel(teachers));

		f.add(p, fl.WEST);
		
		JPanel schedule = new JPanel();
		schedule.setVisible(true);
		schedule.setLayout(new GridLayout(1,5));
		f.add(schedule, BorderLayout.CENTER);
		//sets up names of buttons 
		String [] Monday = {"Monday", "A", "B", "C", "D", "Lunch", "E", "F", "G"};
		String [] Tuesday = {"Tuesday", "B", "C", "D", "E", "Lunch", "F", "G", "A"};
		String [] Wednesday = {"Wednesday", "A1", "A2", "B1", "B2", "Lunch", "C1", "C2", "D1", "D2"};
		String [] Thursday = {"Thursday", "G1", "G2", "F1", "F2", "Lunch", "E1", "E2"};
		String [] Friday = {"Friday", "D", "E", "F", "Lunch", "G", "A", "B", "C"};

		ArrayList<String []> WeekStrings = new ArrayList<String []>(5);
			WeekStrings.add(Monday);
			WeekStrings.add(Tuesday);
			WeekStrings.add(Wednesday);
			WeekStrings.add(Thursday);
			WeekStrings.add(Friday);
			
		ArrayList<JPanel> Week = new ArrayList<JPanel>(5);
		
		blockButtons = new ArrayList<JButton>(40);
		
		for (int i = 0; i < WeekStrings.size(); i++)
		{
			String [] DayStrings = WeekStrings.get(i);
			
			JPanel day = new JPanel();
			JLabel dayLabel = new JLabel(DayStrings[0]);
			day.setLayout(new BorderLayout());
			day.add(dayLabel, BorderLayout.NORTH);
			Week.add(day);
			
			JPanel blocksPanel = new JPanel();

			for (int j = 1; j < DayStrings.length; j++)
			{
				
				blocksPanel.setLayout(new GridLayout(DayStrings.length - 1,0));
								
				JButton button = new JButton(DayStrings[j]);
				
				button.setName(WeekStrings.get(i)[0]);
				
				button.addActionListener(new BtnListener());
				
				button.setEnabled(false);
				
				blocksPanel.add(button);
				
				blockButtons.add(button);
				
			}
			
			day.add(blocksPanel, BorderLayout.CENTER);
			schedule.add(day);
		}

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	/**
	 * for when student selects a block
	 */
	private class BtnListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();
			
			b.setEnabled(false);
			
			selectedBlock = b.getText();
			
			
			JOptionPane.showMessageDialog(null, "You have a meeting for " + selectedBlock + " block on " + b.getName() + " with " + selectedTeacher + ". Do not be late.");
			
			student s = new student(studentname, selectedBlock, b.getName());
			
			l.addStudentData(s, selectedTeacher);
		}
	}
	/**
	 * for when student selects a teacher
	 */
	private class JComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			filter.setEnabled(true);
		}
	}
	/**
	 * for when student filters
	 */
	private class FilterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton f = (JButton)e.getSource();
			
			reset();
			
			f.setEnabled(false);
			
			selectedTeacher = teacherbox.getSelectedItem().toString();
			
			ArrayList<Block> freeBlocks = l.sortThroughTeachers(selectedTeacher);
			
			for (int i = 0; i < 40; i++)
			{
				JButton b = blockButtons.get(i);
				
				String blk = b.getText();
				String day = b.getName();
				
				for (int j = 0; j < freeBlocks.size(); j++)
				{
					String freeblk = freeBlocks.get(j).getName();
					String freeday = freeBlocks.get(j).getDay();
					
					if ((freeblk.equals(blk)) && (day.equals(freeday)))
					{
						b.setEnabled(true);
					}
					
					
				}
								
				
			}
			
		}
	}
	
	public void reset()
	{
		for (int i = 0; i < 40; i++)
		{
			blockButtons.get(i).setEnabled(false);
		}
	}

}



