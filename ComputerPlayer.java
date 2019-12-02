// Sebastian Moreno SXS170103
//Computer Player class: a child of Player, parent of the 3 ComputerPlayers,
//is ran every time the computer class is called.
public class ComputerPlayer extends Player{
    
	public ComputerPlayer(boolean isX) {
		super(isX);
		// TODO Auto-generated constructor stub
	}

	/* The board has been displayed. Prints the statement*/
	public void promptInput() {
		
		if(isX)
			System.out.print("Player X chose an open spot to mark: ");
		else 
			System.out.print("Player O chose an open spot to mark: ");
	}
	
	/* Returns a default value*/
	public int readInput() {
        
		return -1;
	}
	
	public int firstMove() {
		int fMove;
		fMove = (int)(Math.random() * 9)+1;
		return fMove;
	} 
}
