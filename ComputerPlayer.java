//Computer Player class: a child of Player, parent of the 3 ComputerPlayers
public class ComputerPlayer extends Player{
    
	/*
     Pre: The board has been displayed
     Post: Prints the statement
     */
	public void promptInput() {
		
		if(UltimateTicTacToeGame.isPlayerX())
			System.out.print("Player X enter an open spot to mark: ");
		else 
			System.out.print("Player O enter an open spot to mark: ");
	}
	
	/*
     Pre: 
     Post: Returns a default value
     */
	public int readInput() {
        
		return -1;
	}
}
