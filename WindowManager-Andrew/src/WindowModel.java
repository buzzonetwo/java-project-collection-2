import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * This is the view
 * @author buzzonetwo
 *
 */

public class WindowModel extends JPanel {
	/**
	 * WindowManager of the WindowModel
	 */
	private WindowManager wm;
	/**
	 * Width/Height of the WindowModel
	 */
	private int size;
	/**
	 * Used for creating bounding boxes
	 */
	private WindowRect bounder;
	/**
	 * Creates a new custom JPanel with a null LayoutManager that has a WindowManager and a size that will be used to create the 
	 * JFrame containing it. Also displays a message with the JPanel instructions
	 * @param inwm the WindowManager to attach to the view
	 * @param inputsize the size of the WindowModel in pixels, sets size to 100 if input is less than or equal to 0
	 */
	public WindowModel(WindowManager inwm, int inputsize) {
		wm = inwm;
		if (inputsize > 0){
			size = inputsize;
		}
		else {
			size = 100;
		}
		setLayout(null);
		JOptionPane.showMessageDialog(null,"Click+Drag creates rectangles \nClick brings a rectangle to the front \nShift+Click deletes rectangles \nAlt+Drag resizes rectangles \nCtrl+Drag moves rectangles",
				"Instructions for Andrew's Window Manager", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Creates and returns a JFrame to hold the WindowModel
	 * @return a JFrame to hold the WindowModel
	 */
	public JFrame createWindowModel() {
		JFrame f = new JFrame("Andrew's Window Manager");
		f.setSize(size,size);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		return f;
	}
	
	/**
	 * Sets the bounding box to be drawn
	 * @param wr the WindowRect of the bounding box
	 */
	public void setBounder(WindowRect wr) {
		bounder = wr;
	}
	/**
	 * Calls the UI delegate's paint method. First cleans up the linked list of the object's
	 * WindowManager, then either paints the graphics of each WindowRect in the linked list of the object's
	 * WindowManager. If a bounding box needs to be drawn, it does that too.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		wm.cleanUp();
		for (int i = 0; i < wm.getRectList().getLength(); i++) {
			wm.getRectList().get(i).paintRect(g);
		}		
		if (bounder != null) {
			g.setColor(new Color(0));
			g.drawRect(bounder.getX(), bounder.getY(), bounder.getWidth(), bounder.getHeight());
		}
	}
	
	public static void main(String[] args) {
		WindowManager wm = new WindowManager();
		WindowModel model1 = new WindowModel(wm,800);
		
		JFrame f = model1.createWindowModel();
		
		f.add(model1);
		EventListener el = new WindowController(wm);
		model1.setLocation(0,0);
		model1.addMouseListener((MouseListener) el);
		model1.addMouseMotionListener((MouseMotionListener) el);
	}
}
