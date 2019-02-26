package assignmentFour;
import java.awt.*;

import apcslib.*;

public class Poowing2 {
	
	public static int r = 255;
	public static int b = 255;
	public static int g = 255;

	public static void main(String[] args) {
		SketchPad paper = new SketchPad(1000,1000,0);
		AWDrawingTool pen = new AWDrawingTool(paper);
		
		
		for (int i = 1; i < 10000; i+=2) {
			pen.drawTriangle(300);
			pen.movec(60,20);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			pen.setColor(pickColor(r,b,g));
			r += 1;
			b -= 1;
			g += 2;
			correctColor();
			
		}

	}
	
	public static Color randomColor() {
		int red = (int) (Math.random()*256);
		int blue = (int) (Math.random()*256);
		int green = (int) (Math.random()*256);
		Color c = new Color(red,blue,green);
		return c;
	}

	public static Color scaleColor() {
		Color c = new Color((r-1),(b-1),(g-1));
		if (r == 0 || b == 0 || g == 0) {
			r = 255;
			b = 255;
			g = 255;
		}
		return c;
	}
	
	public static Color pickColor(int red, int blue, int green) {
		Color c = new Color(red,blue,green);
		return c;
	}
	
	public static void correctColor() {
		if (r < 0) {
			r = 255;
		}
		if (g < 0) {
			g = 255;
		}
		if (b < 0) {
			b = 255;
		}
		if (r > 255) {
			r = 0;
		}
		if (g > 255) {
			g = 0;
		}
		if (b < 255) {
			b = 0;
		}
	}
	
	/*public void colorinc(int r, int b, int g, int x, int y, int z) {
		pen.setColor(pickColor(r,b,g));
		r += x;
		b += y;
		g += z;
		correctColor();
	}*/
}
