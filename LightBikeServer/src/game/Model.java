package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


public class Model {
	View view;
	Controller controller;
	ArrayList<Bike>Bikes=new ArrayList<Bike>();
	long time;
	static String hostName;
	static int portNumber;
	static Socket echoSocket;
	
	static final double speed = .1;
	static final Point bike1Location = new Point(); 

	public static void main( String[] args ){
		
		try {

            Socket echoSocket = new Socket("localhost", 4444);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                
            new Model(out,in);
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host " + hostName);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to " +
	                hostName);
	            System.exit(1);
	        } 		
	}

	public Model(PrintWriter o, BufferedReader in){
		JFrame frame=new JFrame();
		
		view=new View(this, controller);
		controller=new Controller(this, view);
		view.setPreferredSize(new Dimension(500,500));;

		frame.add(view);
		view.setLocation(275,275);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		addKeys(view,o,in);
		time=0;
		
		Bikes.add(new Bike(Color.RED,this,10,250,1));
		Bikes.add(new Bike(Color.MAGENTA,this,490,250,3));
		Bikes.add(new Bike((Color.BLUE),this,250,10,2));
		Bikes.add(new Bike((Color.GREEN),this,250,490,0));
		controller.startTimer();
	}

	@SuppressWarnings(value = { "serial" }) 
	void addKeys(View view, final PrintWriter o, final BufferedReader in){

		view.getInputMap().put(KeyStroke.getKeyStroke("W"),"P1_Up");
		view.getActionMap().put("P1_Up", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.println("1) up");
				Bikes.get(0).setDirection(Bike.Direction_North);
				o.println("Add");
				try {
					System.out.println(in.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
			}
		});

		view.getInputMap().put(KeyStroke.getKeyStroke("D"),"P1_Right");
		view.getActionMap().put("P1_Right", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.println("1) right");
				Bikes.get(0).setDirection(Bike.Direction_East);
			}
		});

		view.getInputMap().put(KeyStroke.getKeyStroke("S"),"P1_Down");
		view.getActionMap().put("P1_Down", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.println("1) down");
				Bikes.get(0).setDirection(Bike.Direction_South);
			}
		});

		view.getInputMap().put(KeyStroke.getKeyStroke("A"),"P1_Left");
		view.getActionMap().put("P1_Left", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.println("1) left");
				Bikes.get(0).setDirection(Bike.Direction_West);
			}
		});





		view.getInputMap().put(KeyStroke.getKeyStroke("UP"),"P2_Up");
		view.getActionMap().put("P2_Up", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.println("2) up");
				Bikes.get(Bikes.size()-1).setDirection(Bike.Direction_North);
			}
		});

		view.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"P2_Right");
		view.getActionMap().put("P2_Right", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.println("2) right");
				Bikes.get(Bikes.size()-1).setDirection(Bike.Direction_East);
			}
		});

		view.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"P2_Down");
		view.getActionMap().put("P2_Down", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.println("2) down");
				Bikes.get(Bikes.size()-1).setDirection(Bike.Direction_South);
			}
		});

		view.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"P2_Left");
		view.getActionMap().put("P2_Left", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.println("2) left");
				Bikes.get(Bikes.size()-1).setDirection(Bike.Direction_West);
			}
		});
		
	}	
		
		
	
	void refresh(){
//System.out.println((int)System.currentTimeMillis());

//System.out.println(Bikes.size());
		//NEEDS A QUEUE OF RECIEVED COMMANDS-EVERY 50 ms MOVES THROUGH QUEUE AND ISSUES COMMANDS
		long timeLast=time;
		long timeElapsed=System.currentTimeMillis()-timeLast;
//System.out.println(timeElapsed);
		if(timeElapsed<20||timeElapsed>50){
			timeElapsed=25;
		}
//System.out.println(timeElapsed);
		for(int i=0;i<Bikes.size();i++){
			Bikes.get(i).move((int)timeElapsed);
		}

		view.repaint();
		boolean[] toBeDeleted=new boolean[Bikes.size()];
		for(int i=0;i<Bikes.size();i++){
//System.out.println("HELP");
			toBeDeleted[i]=Bikes.get(i).isCollided();
//System.out.println(toBeDeleted[i]);
		}
		int k=0;
		String notify="";
		for(int i=0;i<toBeDeleted.length;i++){
			if(toBeDeleted[i]){
				if(Bikes.get(k).color==Color.RED){
					notify+="and Red ";
				}
				else if(Bikes.get(k).color==Color.MAGENTA){
					notify+="and Purple ";			
				}
				else if(Bikes.get(k).color==Color.GREEN){
					notify+="and Green ";			
				}
				else if(Bikes.get(k).color==Color.BLUE){
					notify+="and Blue ";			
				}
				Bikes.remove(k);
				k--;
				System.err.println((int)System.currentTimeMillis());
			}
			k++;
		}
//System.out.println("2");

		int print=0;
		for(int i=0;i<toBeDeleted.length;i++){
			if(toBeDeleted[i]){
				print++;
			}
		}
		if(print>0){
			if(print>2){
				notify+="all ";
			}
			notify+="died. How sad.";
			notify=notify.substring(4, notify.length());
			//JOptionPane.showMessageDialog(null, notify);
			
			view.addChat(notify);
//System.out.println((int)System.currentTimeMillis());
		}
//System.out.println("3");

		time=System.currentTimeMillis();
		if(isOver()){
			controller.stopTimer();
		}

	}

	boolean isOver(){
		if(Bikes.size()<2){
//System.out.println((int)System.currentTimeMillis());

			JOptionPane.showMessageDialog(null, "Game Over!");
			return true;
		}
		return false;
	}
}