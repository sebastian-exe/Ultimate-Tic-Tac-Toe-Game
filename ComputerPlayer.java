//Computer Player class: a child of Player, parent of the 3 ComputerPlayers
public class ComputerPlayer extends Player{
    
	public ComputerPlayer(boolean isX) {
		super(isX);
		// TODO Auto-generated constructor stub
	}

	/*
     Pre: The board has been displayed
     Post: Prints the statement
     */
	public void promptInput() {
		
		if(isX)
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
	
	public int firstMove() {
		int fMove;
		fMove = (int)(Math.random() * 9)+1;
		return fMove;
	} 
}
