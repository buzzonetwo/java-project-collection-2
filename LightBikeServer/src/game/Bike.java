package game;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.ArrayList;

public class Bike {
	private double xLocation;
	private double yLocation;
	private int direction; //0-3, 0 is up, clockwise rotation
	Color color;
	ArrayList<Line2D.Double>lines=new ArrayList<Line2D.Double>();
	Double frontLine;
	Model model;
	Line2D.Double newLine;

	final static int Direction_North=0;
	final static int Direction_East=1;
	final static int Direction_South=2;
	final static int Direction_West=3;
	final static int Line_Width=2;

	Bike(Color color, Model model,int x,int y,int direction){
		this.color=color;
		this.model=model;
		this.xLocation=x;
		this.yLocation=y;
		this.direction=direction;
		frontLine=new Line2D.Double(xLocation,yLocation,xLocation,yLocation);
		lines.add(frontLine);
	}

	void setDirection(int newDirection){
		if(Math.abs((direction-newDirection)%4)!=2 && direction!=newDirection){
			direction=newDirection;	
			if(direction==0){
				yLocation-=.05;
			}
			else if(direction==1){
				xLocation+=.05;
			}
			else if(direction==2){
				yLocation+=.05;
			}
			else if(direction==3){
				xLocation-=.05;
			}
			frontLine=new Line2D.Double(xLocation, yLocation, xLocation, yLocation);
			lines.add(frontLine);
		}
	}

	boolean isCollided(){
		ArrayList<Bike>bikes=model.Bikes;
		for(int i=0;i<bikes.size();i++){
			Bike bike=bikes.get(i);
			for(int k=0;k<bike.lines.size();k++){
				Line2D line=bike.lines.get(k);
				if((line!=frontLine && line!=newLine && newLine.intersectsLine(line)) || xLocation<0 || xLocation>500 || yLocation<0 || yLocation>500){
					return true;
				}
			}
		}
		lines.remove(lines.size()-1);
		frontLine.x2=xLocation;
		frontLine.y2=yLocation;
		return false;
	}

	@SuppressWarnings("static-access")
	void move(int ms){
		//ALSO NEEDS TO UPDATE LINE
		newLine=new Line2D.Double(xLocation,yLocation,xLocation,yLocation);
		if(direction==0){
			yLocation-=model.speed*ms;
		}
		else if(direction==1){
			xLocation+=model.speed*ms;
		}
		else if(direction==2){
			yLocation+=model.speed*ms;
		}
		else if(direction==3){
			xLocation-=model.speed*ms;
		}
		xLocation=Math.round(xLocation*100)/100.0;
		yLocation=Math.round(yLocation*100)/100.0;
		newLine.x2=xLocation;
		newLine.y2=yLocation;
		lines.add(newLine);

	}

	double getxLocation() {
		return xLocation;
	}

	double getyLocation() {
		return yLocation;
	}
}