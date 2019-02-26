package pooer15;

import java.awt.*;
import apcslib.*;

public class Poowing {

	public static void main(String[] args) {
		SketchPad paper = new SketchPad(400,400,0);
		DrawingTool pen = new DrawingTool(paper);
		
		pen.setColor(Color.red);
		for (int i = 1; i < 10000; i+=2) {
			pen.drawCircle(i);
			
			int red = (int) (Math.random()*256);
			int blue = (int) (Math.random()*256);
			int green = (int) (Math.random()*256);
			pen.setColor(new Color(red,blue,green));
		}

	}

}
