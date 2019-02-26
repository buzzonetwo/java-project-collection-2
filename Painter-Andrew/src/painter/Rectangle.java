package painter;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * An class that will create an rectangle stamp
 * @author buzz
 *
 */
public class Rectangle extends Stamp{
	
	/**
	 * Renders a Rectangle on the given graphics object
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
		g.fillRect(x,y,w,h);

		g.setColor(new Color(0));
		g.drawRect(x,y,w,h);
		
	
	}
	/**
	 * Returns a Stamp pointing to a new Rectangle
	 * @return a Stamp pointing to a new Rectangle
	 */
	@Override
	public Stamp newStamp() {
		return new Rectangle();
	}

}
