package painter;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * An class that will create an ellipse stamp
 * @author buzz
 *
 */
public class Ellipse extends Stamp{
	
	/**
	 * Renders a Ellipse on the given graphics object
	 * @param g the Graphics2D object to draw on
	 */
	@Override
	public void render(Graphics2D g) {
		int x;
		int y;
		int w;
		int h;
		if (!invertedX()) {
			x = getX();
			w = (int) getSize().getWidth();
		}
		else {
			x = (int) (getX()-getSize().getWidth());
			w = (int) getSize().getWidth();
		}
		if (!invertedY()) {
			y = getY();
			h = (int) getSize().getHeight();
		}
		else {
			y = (int) (getY()-getSize().getHeight());
			h = (int) getSize().getHeight();	
		}
		g.setColor(this.getColor());
		g.fillOval(x,y,w,h);	
		g.setColor(new Color(0));
		g.drawOval(x,y,w,h);		
	}
	/**
	 * Returns a Stamp pointing to a new Ellipse
	 * @return a Stamp pointing to a new Ellipse
	 */
	@Override
	public Stamp newStamp() {
		return new Ellipse();
	}

}
