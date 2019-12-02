// Sebastian Moreno SXS170103
// RandomComputerPlayer class: child of ComputerPlayer, plays a random integer in an available spot, this is what will ran when the
//user enters AI as their parameter.
import java.util.Random;
public class AIComputerPlayer extends ComputerPlayer{
    
	public AIComputerPlayer(boolean isX) {
		super(isX);
		// TODO Auto-generated constructor stub
	}

	/* The player has been prompted to move. The miniBoard played has been assigned to the board*/
	public int makeMove(TicTacToeBoard inBoard) {
		
		Random generator = new Random();
		int randomInt;
		
		//random number generation
		randomInt = generator.nextInt(9) + 1;
        
		while(!(inBoard.isValidminiBoard(randomInt) && randomInt <= 9 && randomInt >= 1))
			randomInt = generator.nextInt(9) + 1;
        
		return randomInt;
	}
	//define the first move of the AI if it is entered as the first parameter. AKA PlayerX
	public int firstMove() {
		int fMove;
		fMove = (int)(Math.random() * 9)+1;
		return fMove;
	} 
}