import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This is the controller
 * @author buzzonetwo
 *
 */
public class WindowController implements MouseListener,MouseMotionListener{
	/**
	 * the WindowManager that the controller accesses
	 */
	private WindowManager wm;
	/**
	 * First x coordinate
	 */
	private int xPos1;
	/**
	 * First y coordinate
	 */
	private int yPos1;
	/**
	 * Second x coordinate
	 */
	private int xPos2;
	/**
	 * Second x coordinate
	 */
	private int yPos2;
	
	/** 
	 * A reference to a WindowRect that can be accessed throughout the controller
	 */
	private WindowRect wrtop;

	/**
	 * Holds the status of the mouse's position
	 */
	private boolean insideRect;
	/**
	 * Set to wrtop's x coordinate
	 */
	private int a;
	/**
	 * Set to wrtop's y coordinate
	 */
	private int b;
	/**
	 * Set to wrtop's width
	 */
	private int c;
	/**
	 * Set to wrtop's height
	 */
	private int d;
	
	/**
	 * Holds the status of whether Ctrl is held when the mouse clicked
	 */
	private boolean ctrlHoldcurr;
	/**
	 * Holds the status of whether Alt is held when the mouse clicked
	 */
	private boolean altHoldcurr;
	/**
	 * Holds the status of whether Ctrl is held at the current time
	 */
	private boolean ctrlHoldnew;
	/**
	 * Holds the status of whether Alt is held at a the current time
	 */
	private boolean altHoldnew;
	/**
	 * Holds the status of whether Shift is held at a the current time
	 */
	private boolean shiftHoldnew;
	/**
	 * Creates a controller that attaches to a WindowManager
	 * @param inwm the WindowManager to attach to
	 */
	public WindowController(WindowManager inwm) {
		wm = inwm;
		insideRect = false;
		ctrlHoldcurr = false;
		altHoldcurr = false;
		ctrlHoldnew = false;
		altHoldnew = false;
		shiftHoldnew = false;
	}
	/**
	 * Handles the moving and resizing of WindowRects as well as creating an intermediate
	 *  WindowRect and its corresponding bounding box. Repaints at the end of its call.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {

		
		if (!e.isControlDown()) {
			ctrlHoldnew = false;
		}
		if (!e.isAltDown()) {
			altHoldnew = false;
		}
		if (!e.isShiftDown()) {
			shiftHoldnew = false;
		}
		if (shiftHoldnew) {
			//Don't allow anything to happen
		}
		//a,b,c,d are attributes of the clicked rectangle (x,y,w,h)
		else if (e.isAltDown() && altHoldnew && insideRect) {
			if (wrtop != null) {
				wm.getRectList().remove(wrtop);
				int tempwidth = c+e.getX()-xPos1;
				int tempheight = d+e.getY()-yPos1;
				if (tempwidth < 0) {
					wrtop.setLocation(a+tempwidth, wrtop.getY());
					tempwidth = Math.abs(tempwidth);
				}
				if (tempheight < 0) {
					wrtop.setLocation(wrtop.getX(), b+tempheight);
					tempheight = Math.abs(tempheight);
				}
				wrtop.setSize(tempwidth, tempheight);
				wm.getRectList().addEnd(wrtop);
				
			}
		}
		else if (e.isControlDown() && ctrlHoldnew) {
			if (wrtop != null) {
				wm.getRectList().remove(wrtop);
				wrtop.setLocation(a+e.getX()-xPos1, b+e.getY()-yPos1);
				wm.getRectList().addEnd(wrtop);
			}
		}
		else {
			xPos2 = e.getX();
			yPos2 = e.getY();
			WindowRect temp = newRect();
			((WindowModel) e.getComponent()).setBounder(temp);
			if ((!altHoldnew && altHoldcurr) || (ctrlHoldcurr && !ctrlHoldnew) || shiftHoldnew) { 
				//altHoldnew and ctrlHoldnew check whether alt or control were ever pressed while 
				//altHoldcurr and ctrlHoldcurr check if they were held at the beginning of the click
				((WindowModel) e.getComponent()).setBounder(null);
			}
		}
		e.getComponent().repaint();
	}

	/**
	 * Not overridden
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	/**
	 * Not overridden
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	/**
	 * Handles the setting of the mouse's initial coordinates on press and the set up for the moving and resizing 
	 * of WindowRects as well as the deleting and bringing to the top of WindowRects. Repaints if necessary and also 
	 * sets whether or not the mouse is clicking on a WindowRect
	 */
	@Override
	public void mousePressed(MouseEvent e) {
				
		xPos1 = e.getX();
		yPos1 = e.getY();
		wrtop = clickedRect();
		if (e.isControlDown()) {
			ctrlHoldcurr = true;
			ctrlHoldnew = true;
		}
		if (e.isAltDown()) {
			altHoldcurr = true;
			altHoldnew = true;
		}
		if (e.isShiftDown()) {
			shiftHoldnew = true;
		}
		if (!(e.getComponent().getComponentAt(xPos1, yPos1) instanceof JPanel)) {
			insideRect = true;
			if (wrtop != null) {
				//very descriptive variables - attributes of the clicked rectangle
				a = wrtop.getX(); 
				b = wrtop.getY();
				c = wrtop.getWidth();
				d = wrtop.getHeight();
				if (!e.isControlDown() || !e.isAltDown()) {
					if (e.isShiftDown()) {
						wm.getRectList().remove(wrtop);
						((JPanel) e.getComponent()).remove(wrtop);
					}
					else {
						wm.getRectList().addEnd(wrtop);
						wm.getRectList().remove(wrtop);	
					}
				}
			}
			e.getComponent().repaint();
		}
		else {
			insideRect = false;
		}
	}
	/**
	 * Creates a new WindowRect if necessary and resets certain instance variables. Repaints at the end of its call.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		xPos2 = e.getX();
		yPos2 = e.getY();
		if (!ctrlHoldcurr && !altHoldcurr && !shiftHoldnew) {
			WindowRect wrx = newRect();
			wm.getRectList().addEnd(wrx);
			((JPanel) e.getComponent()).add(wrx);
		}
		((WindowModel) e.getComponent()).setBounder(null);
		ctrlHoldcurr = false;
		altHoldcurr = false;
		shiftHoldnew = false;
		e.getComponent().repaint();
	}

	/**
	 * Not overridden
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Not overridden
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Convenience method to create a new WindowRect with coordinates specified by the instance variables
	 * @return a new WindowRect with parameters xPos1,yPos1,xPos2,yPos2
	 */
	private WindowRect newRect() {
		WindowRect temp = new WindowRect(xPos1,yPos1,xPos2,yPos2);
		return temp;
		
	}
	/**
	 * Returns the top rectangle at the coordinates of xPos1,yPos1
	 * @return the top rectangle at the coordinates of xPos1,yPos1
	 */
	private WindowRect clickedRect() {
		ArrayList<WindowRect> wrlist = new ArrayList<WindowRect>();
		for (int i = 0; i < wm.getRectList().getLength(); i++) {
			int a = xPos1 - wm.getRectList().get(i).getX();
			int b = yPos1 - wm.getRectList().get(i).getY();
			if (wm.getRectList().get(i).contains(a, b) == true) {
				wrlist.add(wm.getRectList().get(i));
			}
		}
		if (wrlist.size() > 0) {
			return wrlist.get(wrlist.size()-1);
		}
		else {
			return null;
		}
	}
	
}