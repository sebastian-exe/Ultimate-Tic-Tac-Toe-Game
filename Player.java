// Sebastian Moreno SXS170103
// Player class: a prototype for how a Player functions.
public class Player {
	
	protected boolean isX;
	
	public Player(boolean isX) {
		this.isX = isX;
	}
	
	/*The board has been printed*/
	public void promptInput() {
        
        //This checks to see which player's turn it currently is.
		if (isX)
			System.out.print("Player X chose an open spot to mark: ");
		else
            System.out.print("Player O chose an open spot to mark: ");
	}
	
	public int firstMove() {
		return -1;
	}
	/* returns a default value*/
	public int makeMove(TicTacToeBoard inBoard) {
        
		return -1;
	}
    
	/* returns a default value */
	public int readInput() {
        
		return -1;
	}
}
