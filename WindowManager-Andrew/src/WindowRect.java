import java.awt.*;
import java.util.Random;

import javax.swing.*;

/**
 * These are the rectangles
 * @author buzzonetwo
 *
 */

public class WindowRect extends JComponent {
	   
    /**
     * Color of WindowRect
     */
	private Color color;
    
	/**
	 * Creates a new WindowRect extending JComponent. The size is calculated based on the absolute 
	 * value differences of the parameters. The location is based on the lower of the values of the 
	 * coordinates. Color of the WindowRect is randomized. All parameters should be positive.
	 * @param xP1 the first x-coordinate
	 * @param yP1 the second x-coordinate
	 * @param xP2 the first y-coordinate
	 * @param yP2 the second y-coordinate
	 */
    public WindowRect(int xP1, int yP1, int xP2, int yP2) {
    	int xPos1;
    	int yPos1;
		if (xP2 > xP1) {
    		xPos1 = xP1;
    	}
    	else {
    		xPos1 = xP2;
    	}
    	if (yP2 > yP1) {
    		yPos1 = yP1;
    	}
    	else {
    		yPos1 = yP2;
    	}
    	
    	super.setSize(Math.abs(xP2-xP1),Math.abs(yP2-yP1));
    	super.setLocation(xPos1,yPos1);
    	
    	Random r = new Random();
    	color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

   /**
    * Returns the color of this WindowRect
    * @return the color of this WindowRect
    */
    public Color getColor() {
		return color;
    	
    }
    /**
     * Sets the color of this WindowRect
     * @param c the new color
     */
    public void setColor(Color c) {
    	color = c;
    }
    /**
     * Paints the WindowRect onto the specified graphics context using the WindowRect's color and includes a black border
     * @param g the graphics object to draw on
     */
    public void paintRect(Graphics g){
        g.setColor(color);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
        g.setColor(new Color(0));
        g.drawRect(getX(),getY(),getWidth(),getHeight());
    }

}
