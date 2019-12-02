// HumanPlayer class: child of Player, functions as the human player in the game
import java.util.*;
public class HumanPlayer extends Player {
    
	public HumanPlayer(boolean isX) {
		super(isX);
		// TODO Auto-generated constructor stub
	}

	Scanner keyboard = new Scanner(System.in);
	private int inputVal;
    
	/*
     Pre: The player has been prompted to move
     Post: The space played has been assigned to the board
     */
	public int makeMove(TicTacToeBoard inBoard) {
        
		try {
			
			inputVal = keyboard.nextInt();
			
			// checking for valid space between 1 and 9
			if (inputVal < 1 || inputVal > 9 || !inBoard.isValidSpace(inputVal)) {
                
				System.out.println("Please enter an open spot between 1 and 9.");
				promptInput();
				makeMove(inBoard);
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
	public int firstMove() {
		int fMove = 0;
		
		

		try {
			
			fMove = keyboard.nextInt();
			
			// checking for valid space between 1 and 9
			if (inputVal < 0 || inputVal > 8) {
				System.out.println("Please enter an open spot between 1 and 9.");
				firstMove();
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
        return fMove;
	}
		
	
}
