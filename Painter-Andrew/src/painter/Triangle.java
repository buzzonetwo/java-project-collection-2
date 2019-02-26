package painter;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * An class that will create an triangle stamp
 * @author buzz
 *
 */
public class Triangle extends Stamp{

	/**
	 * Renders a Triangle on the given graphics object
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
			y = (int) (getY());
			h = (int) -getSize().getHeight();	
		}
		int xPoints[] = {x, x + (w/2), x + w};
		int yPoints[] = {y, y + h, y};
		g.setColor(this.getColor());
		g.fillPolygon(xPoints, yPoints, 3);

		g.setColor(new Color(0));
		g.drawPolygon(xPoints, yPoints, 3);
	}

	/**
	 * Returns a Stamp pointing to a new Triangle
	 * @return a Stamp pointing to a new Triangle
	 */
	@Override
	public Stamp newStamp() {
		return new Triangle();
	}

}
