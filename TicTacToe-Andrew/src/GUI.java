import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 * @author Brian Sea
 * @date 08/01/2015
 */


public class GUI {
	private JButton[] board;
	private GameLogic logic;
	private JButton reset;
	/**
	 * Creates the graphical frontend of TicTacToe with the default logic
	 */
	public GUI() {
		String construct = JOptionPane.showInputDialog("How big should a side be?");
		int constructInt = 3;
		if (!(construct != null)) {
			System.exit(0);
		}
		try {
			constructInt = (Integer.valueOf(construct));
			if (constructInt > 30 || constructInt < 1) {
				JOptionPane.showMessageDialog(null, "Invalid Number");
				System.exit(0);
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid Number");
			System.exit(0);
		}
		logic = new GameLogic(constructInt*constructInt);
		
		/*
		 * Create the number of spaces needs for the baord
		 */
		board = new JButton[logic.numSpaces()];
		
		// Create the actual buttons and attach
		// ActionListeners to each one
		for( int i = 0; i < board.length; i++ ) {
			/*
			 * TODO: Create the buttons and attach them to the array
			 */
			board[i] = new JButton();
			board[i].addActionListener( new BtnListener() );
		}
		
		reset = new JButton("Reset");
		reset.addActionListener( new ResetListener() );
	}
	
	// This method is called each time we want to update
	// the board
	private void updateBoard() {
		
		// Go through the board and place the correct
		// text in each button
		for( int i = 0; i < board.length; i++ ) {
			String filled = logic.getPlayer(i);
			board[i].setText( filled );
			/*
			 * TODO: If the button is filled, then disable it
			 */
		}
	}

	/**
	 * Creates the graphical pieces of the front-end
	 * @return the frame to show on the screen
	 */
	public JFrame createGUI(){
		JFrame f = new JFrame("Tic Tac Toe");
		f.setLayout( new BorderLayout(2, 1));
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout((int) Math.sqrt(board.length), (int) Math.sqrt(board.length)));
		// TODO: fix the board layout
		for( int i = 0; i < board.length; i++ ) {
			panel.add(board[i]);
		}
		f.add( panel, BorderLayout.CENTER);
		f.add( reset, BorderLayout.SOUTH);
		
		return f;
	}
	
	
	
	private class BtnListener implements ActionListener{
		public void actionPerformed( ActionEvent e )
		{
			if (logic.checkWin().equals("")) {
			// Get the button that was pressed
			JButton b = (JButton)e.getSource();
				for( int i = 0; i < board.length; i++ ) {
				// if the button is in the board
					if( b == board[i] ){
						// Button i was pressed!
					
					/*
					 * TODO: Make the move in the logic
					 * TODO: Update the board
					 * TODO: Check for a winner
					 * TODO: Handle a Tie
					 */
						logic.makeMove(i);
						updateBoard();
						if (logic.checkWin().equals("X")) {
						JOptionPane.showMessageDialog(null, "X wins");
						}	
						else if (logic.checkWin().equals("O")) {
							JOptionPane.showMessageDialog(null, "O wins");
						}
						else if (logic.checkWin().equals("Tie")) {
							JOptionPane.showMessageDialog(null, "Tie");
						}
					}
				}
			}
		}
	}
	
	// This listener 'fires' when the rest button is pressed and
	// it should reset the logic and board
	private class ResetListener implements ActionListener{
		public void actionPerformed( ActionEvent e ) {
			// TODO: Complete Me!
			logic.reset();
			for( int i = 0; i < board.length; i++ ) {
				board[i].addActionListener( new BtnListener() );
			}
			updateBoard();
		}
	}
	
	public static void main(String[] args) {
		GUI app = new GUI();
		JFrame f = app.createGUI();
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}
}
