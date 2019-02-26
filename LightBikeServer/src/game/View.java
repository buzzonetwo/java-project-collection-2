package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class View extends JPanel{
	Model model;
	Controller controller;
	boolean crazyDoge = false;
	String[] chat ={"","","",""};
	
	
	View(Model model, Controller controller){
		this.model=model;
		this.controller=controller;
		this.setSize(500, 500);
	}
	
	void addChat(String text){
		for(int i=3;i>0;i--){
			chat[i]=chat[i-1];
		}
		chat[0]=text;
	}

	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D)g;
		if(crazyDoge){
				try {
					g2.drawImage(ImageIO.read(new File("src/game/Doge.jpg")),0,0,500,500,this);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				g2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255),192));
		}
		else{
			g2.setColor(Color.WHITE);
		}
		g2.fillRect(0, 0, 500, 500);
		for(int i=0;i<model.Bikes.size();i++){
			g2.setColor(model.Bikes.get(i).color);
			g2.fillRect((int)model.Bikes.get(i).getxLocation()-5,(int)model.Bikes.get(i).getyLocation()-5, 10, 10);
			g2.setStroke(new BasicStroke(Bike.Line_Width));
			for(int k=0;k<model.Bikes.get(i).lines.size();k++){
				g2.drawLine((int)model.Bikes.get(i).lines.get(k).getX1(), (int)model.Bikes.get(i).lines.get(k).getY1(), (int)model.Bikes.get(i).lines.get(k).getX2(), (int)model.Bikes.get(i).lines.get(k).getY2());
			}
		}
		g2.setColor(Color.BLACK);
		for(int i=0;i<chat.length;i++){
			g2.drawString(chat[i],10,485-20*i);
		}
	}
}