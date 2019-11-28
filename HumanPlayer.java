// HumanPlayer class: child of Player, functions as the human player in the game
import java.util.*;
public class HumanPlayer extends Player {
    
	Scanner keyboard = new Scanner(System.in);
	private int inputVal;
    
	/*
     Pre: The player has been prompted to move
     Post: The space played has been assigned to the board
     */
	public int makeMove() {
        
		try {
			
			inputVal = keyboard.nextInt();
			
			// checking for valid space between 1 and 9
			if (inputVal < 1 || inputVal > 9 || !UltimateTicTacToeGame.isValidSpace(inputVal)) {
                
				System.out.println("Please enter an open spot between 1 and 9.");
				promptInput();
				makeMove();
			}
		}
        
		// Exception handling: will exit when caught
		catch (InputMismatchException e) {
            
			System.out.println("Integers between 1 and 9 only... Try again. Program exiting!");
			System.exit(1);
		}
		catch (NoSuchElementException e) {
            
            System.out.println("No such element! Sorry bout that... Program exiting.");
			System.exit(2);
		}
		catch (IllegalStateException e) {
            
			System.out.println("Scanner is closed. Exiting.");
			System.exit(3);
		}
        
		return inputVal;
	}
}
