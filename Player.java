// Player class: a prototype for how a Player functions.
public class Player {
	
	protected boolean isX;
	
	public Player(boolean isX) {
		this.isX = isX;
	}
	
	/*
     Pre: The board has been printed
     */
	public void promptInput() {
        
        //This checks to see which player's turn it currenly is.
		if (isX)
			System.out.print("Player X enter an open spot to mark: ");
		else
            System.out.print("Player O enter an open spot to mark: ");
	}
	
	public int firstMove() {
		return -1;
	}
	/*
     Post: returns a default value.
     */
	public int makeMove(TicTacToeBoard inBoard) {
        
		return -1;
	}
    
	/* 
     Post: returns a default value
     */
	public int readInput() {
        
		return -1;
	}
}
