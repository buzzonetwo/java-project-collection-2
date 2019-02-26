package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Controller {
	Model model;
	View view;
	Timer timer;
	
	Controller(Model modea, View view){
		this.model=modea;
		this.view=view;
		int delay = 25;
		ActionListener gameTimer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			model.refresh();
			}
		};
		timer=new Timer(delay, gameTimer);
	}
	
	void stopTimer(){
		timer.stop();
	}
	
	void startTimer(){
		timer.start();
	}
}
