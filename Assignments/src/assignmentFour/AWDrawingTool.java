package assignmentFour;

import apcslib.*;

import java.awt.*;

public class AWDrawingTool extends DrawingTool {
	
	public AWDrawingTool(SketchPad thepaper) {
		super(thepaper);
	}
	
	public void drawSquare(int sidelength) {
		for (int i = 0; i < 4; i++) {
			move(sidelength);
			turn(90);
		}
	}
			
	public void drawTriangle(int sidelength) {
			for (int i = 0; i < 4; i++) {
				move(sidelength);
				turn(120);
		}	
	}
	
	public void drawHexagon(int sidelength) {
		for (int i = 0; i < 6; i++) {
			move(sidelength);
			turn(60);
	}	
}
	public void drawPoly(int sidelength, int angle) {
		for (int i = 0; i < 4; i++) {
			move(sidelength);
			turn(angle);
		}		
	}
		
	public void drawRandom() {
		for (int i = 0; i < (int)(Math.random()*100); i++) {
			move(Math.random()*10);
			turn(Math.random()*10);
		}	
	}
	
	public void drawRandom(int k, int j) {
		for (int i = 0; i < (int)(Math.random()*100); i++) {
			move(Math.random()*k);
			turn(Math.random()*j);
		}	
	}
	
	public void movec(int i, int j) {
		move(i);
		turn(j);
	}
	
	
	
}
