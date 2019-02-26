import java.util.List;

import gamecabinet.GameState;
import gamecabinet.Move;
import gamecabinet.Player;


public class AIPlayer extends Player{

	public AIPlayer() {
		
	}

	@Override 
	public boolean isHuman() {
		return false;
	}
	@Override
	public String getName() {
		return "Caopwn";
	}
	public String getDescription() {
		return "Pooper";
	}
	@Override
	public Move makeMove(GameState gs, Move m) {
		MiniMaxTree mtree = new MiniMaxTree();
		
	    gs.removeAllGameStateListeners();

		int depth = 4;
	    while (depth < 24 && !Thread.interrupted()) {
	    	Move bestMove = mtree.chooseMove(gs, depth, getSelf(gs));
	    	m.setX(bestMove.getX());
	    	m.setY(bestMove.getY());
	    	m.setZ(0);
	       	depth += 2;
	       	
	    }
		return m; 
	}
	
	/**
	 * Gets the location of this Player's position in the GameState's list of players
	 * @param gs current GameState
	 * @return the location of this Player's position in the GameState's list of players
	 */
	public int getSelf(GameState gs) {
		int p = 0;
		List<Player> pl = gs.getPlayers();
		for (int i = 0; i < pl.size(); i++) {
			if (pl.get(i).equals(this)) {
				p = i;
			}
		}
		return p;
	}
}
