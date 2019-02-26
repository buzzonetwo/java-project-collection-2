import java.util.List;
import gamecabinet.GameState;
import gamecabinet.Move;
import gamecabinet.Player;

public class MiniMaxTree {

	GameState base;
	StateNode root;
	
	public Move chooseMove(GameState gs, int depth, int pnum) {
		// TODO Auto-generated constructor stub
		base = gs;
		root = new StateNode(base, pnum);
		root.pruner(depth);
		return root.bestMove;
	}

	public class StateNode {

	private int alpha, beta, pnum;
	private boolean isMaxNode;
	private Move bestMove;
	private GameState gs;
	
	//heuristics
	private int p = 0, c = 0, l = 0, d = 0;

	public StateNode(int pnum) {
		this(null, -2147483648, 2147483647, true, pnum);
	}
	
	public StateNode(GameState gs, int pnum) {
		this(gs, -2147483648, 2147483647, true, pnum);
	}
	
	public StateNode(GameState gs, int alpha, int beta, boolean isMax, int pnum) {
	    this.gs = gs;
	    this.alpha = alpha;
	    this.beta = beta;
	    this.isMaxNode = isMax;
	    this.pnum = pnum;
	}
	
	/**
	 * Gets the best move
	 * @return the best move
	 */
	public Move getBestMove() {
		return bestMove;
	}
		
	/**
	 * Creates a new move given coordinates
	 * This really should be a constructor in the class itself 
	 * @param x x-coordinate of the move
	 * @param y y-coordinate of the move
	 * @return a Move of (x,y,0)
	 */
	public Move ezMove(int x, int y) {
		Move m = new Move();
		m.setX(x);
		m.setY(y);
		return m;
	}
	
	/**
	 * Gets the owner of coordinates of move (square on the board)
	 * @param x x-coordinate of the move
	 * @param y y-coordinate of the move
	 * @return the Player that owns (x,y,0)
	 */
	public Player ezPlayer(int x, int y) {
		Move m = ezMove(x,y);
		if (gs.getOwner(m) != null) {
			return gs.getOwner(m);
		}
		else {
			return new Player();
		}
	}
	
	/**
	 * Heuristic function that evaluates normal points, points of of a grid, corners, and corner closeness
	 * based off of https://github.com/kartikkukreja/blog-codes/blob/master/src/Heuristic//%20Function%20for%20Reversi%20(Othello).cpp
	 * @return an integer score
	 * 
	 */
	public int Heu() {
		List<Player> pl = gs.getPlayers();
		Player myAI;
		Player otherAI;
		
		if (pnum == 0) {
			myAI = pl.get(0);
			otherAI = pl.get(1);
		}
		else {
			myAI = pl.get(1);
			otherAI = pl.get(0);
		}
		
		//point grid
		int[][] V = 
		{{520, -103, 11, 8, 8, 11, -103, 520},
	    {-103, -107, -4, 1, 1, -4, -107, -103},
	    {11, -4, 2, 2, 2, 2, -4, 11},
	    {8, 1, 2, -3, -3, 2, 1, 8},
	    {8, 1, 2, -3, -3, 2, 1, 8},
	    {11, -4, 2, 2, 2, 2, -4, 11},
	    {-103, -107, -4, 1, 1, -4, -107, -103},
	    {520, -103, 11, 8, 8, 11, -103, 520}};

		//Grid points
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)  {
				if (ezPlayer(i,j) != null && ezPlayer(i,j).equals(myAI))  {
					d += V[i][j];
				} else if (ezPlayer(i,j) != null && ezPlayer(i,j).equals(otherAI))  {
					d -= V[i][j];
				}
			}
		}
		
		int mytiles = gs.getScore(myAI);
		int othertiles = gs.getScore(otherAI);
		
		//Normal points
		if (mytiles > othertiles) p = (100 * mytiles)/(mytiles + othertiles);
		else if (mytiles < othertiles) p = -(100 * othertiles)/(mytiles + othertiles);
		else p = 0;
		
		mytiles = 0;
		othertiles = 0;
		int myctiles = 0;
		int otherctiles = 0;
		
		//Corner closeness and Corner
		//Corner closeness only gets evaluated if the corner has not been taken
		if (gs.getOwner(ezMove(0,0)) == null)   {
			if (ezPlayer(0,1).equals(myAI)) mytiles++;
			else if (ezPlayer(0,1).equals(otherAI)) othertiles++;
			if (ezPlayer(1,0).equals(myAI)) mytiles++;
			else if (ezPlayer(1,0).equals(otherAI)) othertiles++;
			if (ezPlayer(1,1).equals(myAI)) mytiles++;
			else if (ezPlayer(1,1).equals(otherAI)) othertiles++;
		}
		else if (ezPlayer(0,0).equals(myAI)) myctiles++;
		else if (ezPlayer(0,0).equals(otherAI)) otherctiles++;
		if (gs.getOwner(ezMove(0,7)) == null)   {
			if (ezPlayer(0,6).equals(myAI)) mytiles++;
			else if (ezPlayer(0,6).equals(otherAI)) othertiles++;
			if (ezPlayer(1,6).equals(myAI)) mytiles++;
			else if (ezPlayer(1,6).equals(otherAI)) othertiles++;
			if (ezPlayer(1,7).equals(myAI)) mytiles++;
			else if (ezPlayer(1,7).equals(otherAI)) othertiles++;
		}
		else if (ezPlayer(0,7).equals(myAI)) myctiles++;
		else if (ezPlayer(0,7).equals(otherAI)) otherctiles++;
		if (gs.getOwner(ezMove(7,0)) == null)   {
			if (ezPlayer(6,0).equals(myAI)) mytiles++;
			else if (ezPlayer(6,0).equals(otherAI)) othertiles++;
			if (ezPlayer(6,1).equals(myAI)) mytiles++;
			else if (ezPlayer(6,1).equals(otherAI)) othertiles++;
			if (ezPlayer(7,1).equals(myAI)) mytiles++;
			else if (ezPlayer(7,1).equals(otherAI)) othertiles++;
		}
		else if (ezPlayer(7,0).equals(myAI)) myctiles++;
		else if (ezPlayer(7,0).equals(otherAI)) otherctiles++;
		if (gs.getOwner(ezMove(7,7)) == null)   {
			if (ezPlayer(6,7).equals(myAI)) mytiles++;
			else if (ezPlayer(6,7).equals(otherAI)) othertiles++;
			if (ezPlayer(6,6).equals(myAI)) mytiles++;
			else if (ezPlayer(6,6).equals(otherAI)) othertiles++;
			if (ezPlayer(7,6).equals(myAI)) mytiles++;
			else if (ezPlayer(7,6).equals(otherAI)) othertiles++;
		}
		else if (ezPlayer(7,7).equals(myAI)) myctiles++;
		else if (ezPlayer(7,7).equals(otherAI)) otherctiles++;
		c = myctiles - otherctiles;
		l = mytiles - othertiles;
		
		int eval = ((10 * p) + (5000 * c) + (-1000 * l) + (10 * d));
		return eval;
	}

	/**
	 * Alpha beta pruning
	 * @param depth The depth of the pruned tree
	 * @return Evaluation of the GameState
	 */
	public int pruner(int depth) {
		if (depth == 0) {
			return Heu();
		}
		List<Move> moves = gs.getValidMoves();
	    int counter = 0;
	    while (counter < moves.size() && alpha < beta) {
	    	Move m = (Move) moves.get(counter);
	    	GameState gs2 = gs.copyInstance();
	    	gs2.makeMove(m, m);
	    	StateNode c = new StateNode(gs2, alpha, beta, !isMaxNode, pnum);
	    	int value = c.pruner(depth - 1);
	        if (isMaxNode) {
	        	if (value > alpha) {
	        		alpha = value;
	            	bestMove = m;
	        	}
	        }
	        else if (value < beta)	{
	        	beta = value;
	          	bestMove = m;
	        }
	        counter++;
	    }
	    if (isMaxNode) {
	        return alpha;
	    }
	    return beta;
	}	  
}
}