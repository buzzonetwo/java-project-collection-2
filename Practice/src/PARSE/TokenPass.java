package PARSE;

public class TokenPass {

	private int[] board;
	private int currentPlayer;
	
	public TokenPass(int playerCount) {
		board = new int[playerCount];
		for (int i = 0; i < board.length; i++) {
			board[i] = (int) ((Math.random() * 10) + 1);
		}
		currentPlayer = (int) (Math.random() * playerCount);
	}
	
	public void distributeCurrentPlayerTokens() {
		int nextplayer = (currentPlayer + 1) % board.length ;
		int currenttokens = board[currentPlayer];
		board[currentPlayer] = 0;
		while (currenttokens != 0) {
			board[nextplayer]++;
			currenttokens--;
			nextplayer = (nextplayer + 1) % board.length ;
		}
		
	}
}

