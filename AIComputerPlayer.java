// RandomComputerPlayer class: child of ComputerPlayer, plays a random integer in an available spot
import java.util.Random;
public class AIComputerPlayer extends ComputerPlayer{
    
	public AIComputerPlayer(boolean isX) {
		super(isX);
		// TODO Auto-generated constructor stub
	}

	/*
     Pre: The player has been prompted to move
     Post: The space played has been assigned to the board
     */
	public int makeMove(TicTacToeBoard inBoard) {
		
		Random generator = new Random();
		int randomInt;
		
		//random number generation
		randomInt = generator.nextInt(9) + 1;
        
		while(!(inBoard.isValidSpace(randomInt) && randomInt <= 9 && randomInt >= 1))
			randomInt = generator.nextInt(9) + 1;
        
		return randomInt;
	}
	
	public int firstMove() {
		int fMove;
		fMove = (int)(Math.random() * 9)+1;
		return fMove;
	} 
}