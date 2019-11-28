// Player class: a prototype for how a Player functions.
public class Player {
	
	/*
     Pre: The board has been printed
     */
	public void promptInput() {
        
        //This checks to see which player's turn it currenly is.
		if (UltimateTicTacToeGame.isPlayerX())
			System.out.print("Player X enter an open spot to mark: ");
		else
            System.out.print("Player O enter an open spot to mark: ");
	}
	/*
     Post: returns a default value.
     */
	public int makeMove() {
        
		return -1;
	}
    
	/* 
     Post: returns a default value
     */
	public int readInput() {
        
		return -1;
	}
}
