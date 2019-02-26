/**
 * @author Brian Sea
 * @date 08/01/2015
 */
public class GameLogic {
	
	// The board spaces
	private int[] board;
	
	// Whose turn it is; -1 = 0, 1 = X
	private int turn;
	
	/**
	 * Constructs a Tic-Tac-Toe logic with nine spaces
	 */
	public GameLogic() {
		// Create the array of nine spaces 
		/*
		 * TODO: Create the array of nine spaces
		 */
		board = new int[9];
		reset();
	}
	public GameLogic(Integer integer) {
		// Create the array of nine spaces 
		/*
		 * TODO: Create the array of nine spaces
		 */
		board = new int[integer];
		reset();
	}
	
	/**
	 * Get the number of spaces in the game.  The board will always
	 * be square.
	 * @return the total number of space in the game.
	 */
	public int numSpaces() {
		return board.length;
	}
	
	/**
	 * Resets the board to starting positions.
	 * X always goes first
	 */
	public void reset(){
		for( int i = 0; i < board.length; i++ ) {
			board[i] = 0;
			turn = 1;
		}
	}
	
	/**
	 * @param i the space to make the next move [0, numSpaces-1]
	 * @return true if the move was made, false for an invalid move
	 */
	public boolean makeMove( int i )
	{
		boolean rtn = false;
		
		// Make sure that i is within the board
		if( i >= 0 && i < board.length ) {
			if (turn == 1 && board[i] == 0) {
				board[i] = 1;
				rtn = true;
			}
			else if (turn == -1 && board[i] == 0) {
				board[i] = -1;
				rtn = true;
			}
			
		}
		if (rtn) {
			if (turn == 1) {
				turn = -1;
			}
			else if (turn == -1) {
				turn = 1;
			}
		}
		return rtn;
	}
	
	
	/** 
	 * @return The player that has won as a String ("X", "O", "Tie", "")
	 * @return "X" if X wins
	 * @return "O" if O wins
	 * @return "Tie" if it is a tie
	 * @return "" if the game is not over
	 */
	public String checkWin(){
		String rtn = "";
		
		/*  The board is represented as follows:
		 *     -------------
		 *     | 0 | 1 | 2 |
		 *     -------------
		 *     | 3 | 4 | 5 |
		 *     -------------
		 *     | 6 | 7 | 8 |
		 *     -------------
		 *     
		 *     Since O is -1 and X is 1, if the 
		 *     sum of any row or column or diagonal
		 *     adds to 3 or -3, we know that we have 
		 *     a winner
		 */
		
		int sum = 0;
		
		int side = (int) Math.sqrt(board.length);
		// Check Rows
		/*
		 * TODO: Check Rows Here
		 */
		boolean xcheckrow = false;
		boolean ocheckrow = false;
		for (int i = 0; i < side; i++) {
			int sumrow = 0;
			for (int j = 0 ; j < side; j++) {
				sumrow += board[(i*side)+j];
			}
			if (sumrow == side) {
				xcheckrow = true;
			}
			if (sumrow == -side) {
				ocheckrow = true;
			}
		}
		if (xcheckrow) {
			rtn = "X";
		}
		else if (ocheckrow) {
			rtn = "O";
		}
		// Check Columns
		/*
		 * TODO: Check Columns Here
		 */
		boolean xcheckcol = false;
		boolean ocheckcol = false;
		for (int i = 0; i < side; i++) {
			int sumcol = 0;
			for (int j = 0 ; j < side; j++) {
				sumcol += board[i+(j*side)];
			}
			if (sumcol == side) {
				xcheckcol = true;
			}
			if (sumcol == -side) {
				ocheckcol = true;
			}
		}
		if (xcheckcol) {
			rtn = "X";
		}
		else if (ocheckcol) {
			rtn = "O";
		}
		
		// Check Diagonals
		/*
		 * TODO: Check Diagonals here
		 */
		int sumdiag1 = 0;
		int tempdiag1 = 0;
		for (int k = 0; k < side; k++) {
			sumdiag1 += board[tempdiag1];
			tempdiag1 += (side+1);
		}
		
		int sumdiag2 = 0;
		int tempdiag2 = side-1;
		for (int j = 0; j < side; j++) {
			sumdiag2 += board[tempdiag2];
			tempdiag2 += (side-1);
		}
		
		if (sumdiag1 == side || sumdiag2 == side) {
			rtn = "X";
			
		}
		if (sumdiag1 == -side || sumdiag2 == -side) {
			rtn = "O";
		}
		// Check for a Tie
		/*
		 * TODO:  Check for a tie. You may add a field for this to work
		 */
		else if (tieCheck() && rtn.equals("")) {
			rtn = "Tie";
		}
		
		return rtn;
	}
	
	/**
	 * @param space the index of the space to check [0, numSpace() - 1]
	 * @return the player in the space; An empty string is returned if the space is blank.
	 */
	public String getPlayer( int space ) {
		String rtn = "";
		
		// Check that the space is in the board
		if( space >= 0 && space < board.length )
		{
			// It is, so translate it the player number
			// into a human readable string
			if( board[space ] == 1 ) {
				rtn = "X";
			}
			else if( board[space] == -1 )
			{
				rtn = "O";
			}
		}
		return rtn;
	}
	
	public boolean tieCheck() {
		boolean check = true;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				check = false;
			}
		}
		return check;
	}
}
