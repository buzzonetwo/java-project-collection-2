import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class TeacherBox {

	JComboBox teacherboxt;//combo box with teacher's name
	JComboBox blockboxt;// combo box with their free blocks
	JComboBox day;

	private Logic l;

	public TeacherBox(Logic logic)
	{
		l = logic;

		JOptionPane.showMessageDialog(null, "Please select the blocks that you are free. Select your name from the drop down menu and hit Send.");

		JFrame f = new JFrame("Office Hours (Teacher)");
		BorderLayout fl = new BorderLayout();
		f.setLayout(fl);
		f.setSize(600,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel schedule = new JPanel();
		schedule.setVisible(true);
		schedule.setLayout(new GridLayout(1,5));
		f.add(schedule, BorderLayout.CENTER);

		//used for labeleing all the buttons
		String [] Monday = {"Monday", "A", "B", "C", "D", "Lunch", "E", "F", "G"};
		String [] Tuesday = {"Tuesday", "B", "C", "D", "E", "Lunch", "F", "G", "A"};
		String [] Wednesday = {"Wednesday", "A1", "A2" , "B1", "B2", "Lunch", "C1", "C2", "D1", "D2"};
		String [] Thursday = {"Thursday", "G1","G2", "F1","F2","Lunch", "E1","E2"};
		String [] Friday = {"Friday", "D", "E", "F", "Lunch", "G", "A", "B", "C"};

		ArrayList<String []> WeekStrings = new ArrayList<String []>(5);
		WeekStrings.add(Monday);
		WeekStrings.add(Tuesday);
		WeekStrings.add(Wednesday);
		WeekStrings.add(Thursday);
		WeekStrings.add(Friday);

		ArrayList<JPanel> Week = new ArrayList<JPanel>(5);

		for (int i = 0; i < WeekStrings.size(); i++)
		{
			String [] DayStrings = WeekStrings.get(i);

			JPanel day = new JPanel();
			JLabel dayLabel = new JLabel(DayStrings[0]);
			day.setLayout(new BorderLayout());
			day.add(dayLabel, BorderLayout.NORTH);
			Week.add(day);

			JPanel blocks = new JPanel();

			for (int j = 1; j < DayStrings.length; j++)
			{

				blocks.setLayout(new GridLayout(DayStrings.length - 1,0));

				JButton button = new JButton(DayStrings[j]);

				button.setName(DayStrings[0]);

				button.addActionListener(new BtnListener());

				blocks.add(button);

			}

			day.add(blocks, BorderLayout.CENTER);
			schedule.add(day);
		}



		JPanel p = new JPanel(); 
		GridBagLayout bl = new GridBagLayout();
		p.setLayout(bl);

		JButton b = new JButton("Send");
		b.setBackground(new Color(59, 89, 182));
		b.addActionListener(new SndListener());




		JPanel r = new JPanel();
		GridLayout gl = new GridLayout(1,2);
		r.setLayout(gl);

		teacherboxt = new JComboBox();
		teacherboxt.setToolTipText("Choose Your Name");
		r.add(teacherboxt);



		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		p.add(r, gbc);

		gbc.gridheight = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.insets = new Insets(100,0, 0, 0);
		p.add(b, gbc);


		String [] teachers = {"Select your name","Andy", "Madam Bordet", "Dr. Brakeman", "Corey", "Mr. Correa", "Ms. Diaz", "Dr. Enelow", "Ms. Fahey", "Fern", "Ms. Galligan", "Ms. Glogover", "Ms. Guergue", "Mr. Harper", "Ms. Kaplan", "Dr. Kinney", "Dr. Lisowski", "Mrs. Mckenna", "Dr. Bradley", "Mr. Clark", "Mr. Davies", "Mr. Evans", "Ms. Feidelman", "Matt Fraser", "Mr. Guzman", "Ms. Krier", "Mrs. Miller", "Mr. Muniz", "Naoko", "Ms. Nguyen", "Ms. Pryor", "Ms. Ray", "Ms. Sanker", "Mr. Schneider", "Mr. Sea", "Ms. Temple", "Mr. Tower", "Ms. V", "Mr. Wells", "Ms. Yee", "Ms. Sarkar", "Mr. Scott", "Ms. Tang", "Mr. Vann", "Mr. Von K", "Ms. Wu"};
		teacherboxt.setModel(new DefaultComboBoxModel(teachers));

		f.add(p, fl.WEST);

		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//we send parallel array lists; by lining them up, the same index gets both the day and block
	ArrayList<String> dayswesend = new ArrayList<String>();
	ArrayList<String> blockswesend = new ArrayList<String>();

	private class BtnListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();

			b.setEnabled(false);

			dayswesend.add(b.getName());
			blockswesend.add(b.getText());
		}
	}
	
	private class SndListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();

			b.setEnabled(false);

			JOptionPane.showMessageDialog(null, "You have sent your free blocks.");

			String teachername = teacherboxt.getSelectedItem().toString();

			l.addTeacherData(teachername, dayswesend, blockswesend);
		}
	}
}
