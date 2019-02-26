import java.awt.*;
import javax.swing.*;



public class SwingIntro {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Poop");
		 
		frame.setLayout(new BorderLayout(2, 1));
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,3));
		
		JButton[] ttt = new JButton[9];
		for (int i = 0; i < ttt.length; i++) {
			ttt[i] = new JButton();
			p.add(ttt[i]);
		}
		
		frame.add(p, BorderLayout.CENTER);
		
		JButton reset = new JButton("Reset");
		frame.add(reset, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		
	}

}
