package painter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class DrawingPane extends JPanel{

	private Stamp selected;
	private ArrayList<Stamp> shapes;
	private Random rand;
	
	public DrawingPane() {
		
		/*
		 * Initialize the drawing pane
		 */
		shapes = new ArrayList<Stamp>();
		rand = new Random();
		
		/* 
		 * Attach the mouse listeners
		 */
		Mouser mouser = new Mouser();
		this.addMouseListener(mouser);
		this.addMouseMotionListener(mouser);
	}
	
	public boolean setSelected( Stamp toUse ){
		boolean rtn = false;
		if( toUse != null ){
			this.selected = toUse;
			rtn = true;
		}
		return rtn;
	}
	
	public Stamp getSelected(){
		return selected;
	}
	
	public void paintComponent( Graphics g ){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		/*
		 * Draws all the stamps in the shapes arraylist
		 */
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).render(g2);
		}
		
		if( selected != null ){
			selected.render(g2);
		}
		
	}
	
	private class Mouser implements MouseListener, MouseMotionListener{

		private int anchorX, anchorY;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			Stamp current = getSelected();
			
			if( current == null ){
				return;
			}
			
			
			/*
			 * Create a new stamp, randomize the color and set it as the current stamp and sets the anchor points
			 */
			anchorX = e.getX();
			anchorY = e.getY();
			current = current.newStamp();
			current.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
			setSelected(current);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
			/*
			 * Sets the size and location given mouse location and anchor location and adds the shape to the arraylist
			 */
			int xPos2 = e.getX();
			int yPos2 = e.getY();
			Stamp current = getSelected();
			
			if (current == null) {
				return;
			}

			current.setSize((float) (xPos2-anchorX), (float) (yPos2-anchorY));
			current.setLocation((float) anchorX, (float) anchorY);
			shapes.add(current);
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			
			Stamp selected = getSelected();
			
			if( selected == null ){
				return;
			}
			
	    	/*
			 * draws temporary stamps given mouse location and anchor location
		   	 */
			int xPos2 = e.getX();
			int yPos2 = e.getY();
			Stamp current = getSelected();
			
			if (current == null) {
				return;
			}
			current.setSize((float) (xPos2-anchorX), (float) (yPos2-anchorY));
			current.setLocation((float) anchorX, (float) anchorY);
			current.render((Graphics2D) e.getComponent().getGraphics());
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}
		
	}
	
}
