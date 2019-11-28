// RandomComputerPlayer class: child of ComputerPlayer, plays a random integer in an available spot
import java.util.Random;
public class AIComputerPlayer extends ComputerPlayer{
    
	/*
     Pre: The player has been prompted to move
     Post: The space played has been assigned to the board
     */
	public int makeMove() {
		
		Random generator = new Random();
		int randomInt;
		
		//random number generation
		randomInt = generator.nextInt(9) + 1;
        
		while(!(UltimateTicTacToeGame.isValidSpace(randomInt) && randomInt <= 9 && randomInt >= 1))
			randomInt = generator.nextInt(9) + 1;
        
		return randomInt;
	}
}