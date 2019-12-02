/************************************************************************
* Title: Ultimate Tic-Tac-Toe Game
* Author: Sebastian Moreno SXS170103
* Course: CS 2336.006
************************************************************************/

/*
Analysis: The challenge is to create a 3 by 3 ultimate tic-tac-toe game
that consist of individual Tic-Tac-Toe games as the squares that make up
the board. The way the game is won is if the player or AI wins three 
individual games. The catch is that these three games have to be won on the
overall ultimate Tic-Tac-Toe-Game just like the individual ones. As in all
three wins have to be next to one another, either horizontally, vertically,
or diagonally. A special rule has been implemented stating that the next move
of either the AI or the Human must be made on the board number correlating to
that of the position played on the individual Tic-Tac-Toe game of the previous
players turn.


Design: I first want to approach this by creating an object of a game type in the 
main driver of the program. After this I want to prompt the user with all of the 
specific rules, and inform the user on how the board of the game works. After input
validating all of their responses, and creating the game my plan is to create a 2
dimensional array Ultimate game board, with the data type of Tic-Tac-Toe board object.
The Tic-Tac-Toe objects are created through 2 dimensional integer array. I will implement
a board interface that will be used for both the Tic-Tac-Toe board class and the 
Ultimate-Tic-Tac-Toe board class. All the players will inherit from a player class. The
player class will extend into the SmartComputerPlayer, Computer Player, AIComputerPlayer, 
and the human player class. The entire game will be ran in the Tic-Tac-Toe game file from 
a big while loop testing the helper methods of other classes.
*/

import java.util.Scanner;

public class TicTacToeGame {
	TicTacToeGame(){
	//prompt the user with the proper instructions to start the game
	 System.out.println("Please enter human, AI, or smartAI as your arguments.");
	 System.out.println("The first arguement will be playerX and the second arguement will be playerO.");
	 System.out.println("If human is selected, please enter both the arguements for the players first,");
	 System.out.println("and then enter the number of the board that you wish to start on.");
	 System.out.println("The board game starts at board 1 and increases from the left to right until the last,");
	 System.out.println("bottom right board which is labeled as board 9. The same is true for each individual ");
	 System.out.println("tic-tac-toe board game.");


	 //read in the arguments
	 Scanner scanner = new Scanner(System.in);
	 String X = scanner.next();
	 String Y = scanner.next();
	 

	Player playerX = null;
	Player playerO = null;
	 
	 //set up the player for the first argument
	if(X.equalsIgnoreCase("human")) {
		playerX = new HumanPlayer(true);
		System.out.print("Please enter the number of the board you wish to start the game on");
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
	//if what the user enters is equal to ai, create an AI object
	else if(Y.equalsIgnoreCase("ai")) {
		playerO = new AIComputerPlayer(false);
	}
	//if what the user enters is equal to smartAI, then create a smartAI object
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
			//check if the game is a tie
            while (gameBoard.isCatGame()) {
            	System.out.print("The board is full, Please enter a number, 1-9 for the board: ");
            
            	boardNumber = playerX.firstMove();
            	System.out.println(boardNumber);
            	gameBoard = board.getBoardByNum(boardNumber);
            }
			playerX.promptInput();
           
			//Check if the player is human or computer.
			if (X.equalsIgnoreCase("human")) {
				makeMoveNum = playerX.makeMove(gameBoard);
				gameBoard.turn(makeMoveNum);
				
                
			}
			else {
				compMove = playerX.makeMove(gameBoard);
				makeMoveNum = compMove;
				System.out.println(compMove);
				gameBoard.turn(compMove);
			}
		}
		else {
           //check if the game is a tie, this essentially just checks if the board is full
			while (gameBoard.isCatGame()) {
            	System.out.print("The board is full, Please enter a number, 1-9 for the board: ");
          
            	boardNumber = playerO.firstMove();
            	System.out.println(boardNumber);
            	gameBoard = board.getBoardByNum(boardNumber);
            }
			playerO.promptInput();
			//Check if the player is human or computer.
			if (Y.equalsIgnoreCase("human")) {
				makeMoveNum = playerO.makeMove(gameBoard);
				gameBoard.turn(makeMoveNum);
                
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
