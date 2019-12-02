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

public class DriverMain {
	 public static void main(String[] args) {
		 TicTacToeGame game = new TicTacToeGame();
	}
}

