import java.util.Scanner;

public class TicTacToeGame {
	TicTacToeGame(){
	//prompt the user
	 System.out.println("Please enter human, AI, or smartAI as your arguments.");
	 System.out.println("The first arguement will be playerX and the second arguement will be playerO");
	 
	 //read in the arguments
	 Scanner scanner = new Scanner(System.in);
	 String X = scanner.next();
	 String Y = scanner.next();
	 

	Player playerX = null;
	Player playerO = null;
	 
	 //set up the player for the first argument
	if(X.equalsIgnoreCase("human")) {
		playerX = new HumanPlayer(true);
	}
	//lets name random to the same as the AI
	else if(X.equalsIgnoreCase("ai")) {
		playerX = new AIComputerPlayer(true);
	}
	//smart AI is the same as the cut throat
	else if(X.equalsIgnoreCase("smartai")) {
		playerX = new SmartComputerPlayer(true);
	}
	else {
		System.out.println("Please enter either human, AI, or smartAI");
		System.exit(0);
	}
	
	//set up the player O with the second argument
	//set up the player for the first argument
	if(Y.equalsIgnoreCase("human")) {
		playerO = new HumanPlayer(false);
	}
	//lets name random to the same as the AI
	else if(Y.equalsIgnoreCase("ai")) {
		playerO = new AIComputerPlayer(false);
	}
	//smart AI is the same as the cut throat
	else if(Y.equalsIgnoreCase("smartai")) {
		playerO = new SmartComputerPlayer(false);
	}
	else {
		System.out.println("Please enter either human, AI, or smartAI");
		System.exit(0);
	}
	
	//prompt the title
	System.out.println(" ");
	System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
	
	UltimateBoard board = new UltimateBoard();

	
	int compMove; 
	
	//first move
	int boardNumber = playerX.firstMove();
	System.out.println("Please enter a number, 1-9 for the board of your first turn: " + boardNumber);

	TicTacToeBoard gameBoard = board.getBoardByNum(boardNumber);
	board.changePlayer();
	//Main game loop which runs helper methods until game ends.
	while(!(board.xWins() || board.oWins() || board.isCatGame())) {
       int makeMoveNum = -1;
		//Allows either player X or player O to play
       System.out.println("Current Board: " + boardNumber);
       gameBoard.printValidSpots();
		if(board.isPlayerX()) {
            while (gameBoard.isCatGame()) {
            	System.out.print("The board is full, Please enter a number, 1-9 for the board: ");
            	//board.displayBoard();
            	boardNumber = playerX.firstMove();
            	System.out.println(boardNumber);
            	gameBoard = board.getBoardByNum(boardNumber);
            }
			playerX.promptInput();
           
			//Check if the player is human or computer.
			if (X.equalsIgnoreCase("human")) {
				makeMoveNum = playerX.makeMove(gameBoard);
				gameBoard.turn(makeMoveNum);
				
                //board.turn(, boardNumber);
			}
			else {
				compMove = playerX.makeMove(gameBoard);
				makeMoveNum = compMove;
				System.out.println(compMove);
				gameBoard.turn(compMove);
			}
		}
		else {
           
			while (gameBoard.isCatGame()) {
            	System.out.print("The board is full, Please enter a number, 1-9 for the board: ");
            	//board.displayBoard();
            	boardNumber = playerO.firstMove();
            	System.out.println(boardNumber);
            	gameBoard = board.getBoardByNum(boardNumber);
            }
			playerO.promptInput();
			//Check if the player is human or computer.
			if (Y.equalsIgnoreCase("human")) {
				makeMoveNum = playerO.makeMove(gameBoard);
				gameBoard.turn(makeMoveNum);
                //board.turn(playerO.makeMove(gameBoard), boardNumber);
			}
			else {
				compMove = playerO.makeMove(gameBoard);
				makeMoveNum = compMove;
				System.out.println(compMove);
				gameBoard.turn(compMove);
			}						
		}
		board.setBoardByNum(gameBoard, boardNumber);
		
		boardNumber = makeMoveNum;
		gameBoard = board.getBoardByNum(boardNumber);
		
        board.displayBoard();
       
	    board.changePlayer();
	}
	//Display game results
	if(board.xWins()) {
       
		board.displayBoard();
		System.out.println("Game Over! Player X wins!\n");
	}
	else if(board.oWins()) {
       
		board.displayBoard();
       System.out.println("Game Over! Player O wins!\n");
	}
	else {
       
		board.displayBoard();
		System.out.println("Game Over! Cat game!\n");
		}
	}
}
