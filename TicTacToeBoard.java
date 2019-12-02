// Sebastian Moreno SXS170103
/*
 This class draws the TicTacToe board and keeps track of the location of all the marks on the board. It also checks for wins and valid miniBoards 
 and keeps track of whose turn it is. 
 */
public class TicTacToeBoard implements IBoard {
    
	private int[][] miniBoard = new int[3][3];
	private boolean playerX = true;
	private boolean playerO = false;
	
    //Constructor, creates an empty board.
	public TicTacToeBoard() {
        
		for (int i = 0; i <= 2; i++) {
            
			for (int j = 0; j <= 2; j++) {
                
				miniBoard[i][j] = 0;
			}
		}
	}
    
	// Draws the board with pipes and dashes and prints out any marks currently in place.
	public void displayBoard(){
        
        System.out.print("\n");
        for (int i = 0; i <= 2; i++) {
            //Draws empty board
            for (int j = 0; j <= 2; j++) {
                
                if (miniBoard[i][j] == 0 && j < 2)
                    System.out.print(" |");
                
                else if (miniBoard[i][j] == 0 && j == 2 && i < 2)
                    System.out.print(" \n-----\n");
                
                else if (miniBoard[i][j] == 0 && j == 2 && i == 2)
                    System.out.println(" \n");
                
                //Draws board with any X's in the relevant place
                else if (miniBoard[i][j] == 1 && j < 2)
                    System.out.print("X|");
                
                else if (miniBoard[i][j] == 1 && j == 2 && i < 2) 
                    System.out.print("X\n-----\n");
                
                else if (miniBoard[i][j] == 1 && j == 2 && i == 2)
                    System.out.println("X\n");
                
                //Draws board with any O's in the relevant place
                else if (miniBoard[i][j] == 2 && j < 2)
                    System.out.print("O|");
                
                else if (miniBoard[i][j] == 2 && j == 2 && i < 2)
                    System.out.print("O\n-----\n");
                
                else if (miniBoard[i][j] == 2 && j == 2 && i == 2)
                    System.out.println("O\n");
            }
        }
		int runner = 0;
    }
	
	public String getDisplayString() {
		String out = "";
		
		out += "\n";
        for (int i = 0; i <= 2; i++) {
            //Draws empty board
            for (int j = 0; j <= 2; j++) {
                
                if (miniBoard[i][j] == 0 && j < 2)
                	out += " |";
                
                else if (miniBoard[i][j] == 0 && j == 2 && i < 2)
                	out += " \n-----\n";
                
                else if (miniBoard[i][j] == 0 && j == 2 && i == 2)
                	out += " \n";
                
                //Draws board with any X's in the relevant place
                else if (miniBoard[i][j] == 1 && j < 2)
                	out += "X|";
                
                else if (miniBoard[i][j] == 1 && j == 2 && i < 2) 
                	out += "X\n-----\n";
                
                else if (miniBoard[i][j] == 1 && j == 2 && i == 2)
                	out += "X\n";
                
                //Draws board with any O's in the relevant place
                else if (miniBoard[i][j] == 2 && j < 2)
                	out += "O|";
                
                else if (miniBoard[i][j] == 2 && j == 2 && i < 2)
                	out += "O\n-----\n";
                
                else if (miniBoard[i][j] == 2 && j == 2 && i == 2)
                	out += "O\n";
            }
        }
		
		return out;
	}
    
	//Pre: There is a board and a player has entered in a miniBoard to mark
	//Post: The corresponding miniBoard is marked with a 1 or a 2, which translates
	//to an X or an O when read by drawBoard.
	public void turn(int playminiBoard){
        
        if(playerX){
            switch (playminiBoard) {
                    
                case 1: miniBoard[0][0] = 1; break;
                case 2: miniBoard[0][1] = 1; break;
                case 3: miniBoard[0][2] = 1; break;
                case 4: miniBoard[1][0] = 1; break;
                case 5: miniBoard[1][1] = 1; break;
                case 6: miniBoard[1][2] = 1; break;
                case 7: miniBoard[2][0] = 1; break;
                case 8: miniBoard[2][1] = 1; break;
                case 9: miniBoard[2][2] = 1; break;
            }
        }
        
        //player O's miniBoard
        else{
            
            switch (playminiBoard) {
                    
                case 1: miniBoard[0][0] = 2; break;
                case 2: miniBoard[0][1] = 2; break;
                case 3: miniBoard[0][2] = 2; break;
                case 4: miniBoard[1][0] = 2; break;
                case 5: miniBoard[1][1] = 2; break;
                case 6: miniBoard[1][2] = 2; break;
                case 7: miniBoard[2][0] = 2; break;
                case 8: miniBoard[2][1] = 2; break;
                case 9: miniBoard[2][2] = 2; break;
            }
        }
    }	
    
    //Pre: There is a miniBoard to retrieve.
	//Post: The miniBoard is returned.
	public int getminiBoard(int i){
		
		switch (i) {
			case 1: return miniBoard[0][0];
          	case 2: return miniBoard[0][1];
          	case 3: return miniBoard[0][2];
          	case 4: return miniBoard[1][0];
            case 5: return miniBoard[1][1];
          	case 6: return miniBoard[1][2];
          	case 7: return miniBoard[2][0];
          	case 8: return miniBoard[2][1];
          	case 9: return miniBoard[2][2];
		}
		return -1;
	}
    
	//Post: It is now the opposite player's turn.
	public void changePlayer(){
        if(playerX){
            playerX = false;
            playerO = true;
        }
        else{
            playerX = true;
            playerO = false;
        }
        
    }    
    
    //Post: Returns whose turn it is. Player O is implicitly false.
	public boolean isPlayerX(){
        
        return playerX;
    }	
    
	//Post: Returns that player X wins if any of the following conditions are met.
	public boolean xWins() {
        
        if(miniBoard[0][0]==1 && miniBoard[0][1]==1 && miniBoard[0][2]==1)
            return true;
        else if(miniBoard[1][0]==1 && miniBoard[1][1]==1 && miniBoard[1][2]==1)
            return true;
        else if(miniBoard[2][0]==1 && miniBoard[2][1]==1 && miniBoard[2][2]==1)
            return true;
        else if(miniBoard[0][0]==1 && miniBoard[1][0]==1 && miniBoard[2][0]==1)
            return true;
        else if(miniBoard[0][1]==1 && miniBoard[1][1]==1 && miniBoard[2][1]==1)
            return true;
        else if(miniBoard[0][2]==1 && miniBoard[1][2]==1 && miniBoard[2][2]==1)
            return true;
        else if(miniBoard[0][0]==1 && miniBoard[1][1]==1 && miniBoard[2][2]==1)
            return true;
        else if(miniBoard[0][2]==1 && miniBoard[1][1]==1 && miniBoard[2][0]==1)
            return true;
        else
            return false;
        
    }
    
	
	//Post: Returns that player O wins if any of the following conditions are met.
	public boolean oWins() {
        
        if(miniBoard[0][0]==2 && miniBoard[0][1]==2 && miniBoard[0][2]==2)
            return true;
        else if(miniBoard[1][0]==2 && miniBoard[1][1]==2 && miniBoard[1][2]==2)
            return true;
        else if(miniBoard[2][0]==2 && miniBoard[2][1]==2 && miniBoard[2][2]==2)
            return true;
        else if(miniBoard[0][0]==2 && miniBoard[1][0]==2 && miniBoard[2][0]==2)
            return true;
        else if(miniBoard[0][1]==2 && miniBoard[1][1]==2 && miniBoard[2][1]==2)
            return true;
        else if(miniBoard[0][2]==2 && miniBoard[1][2]==2 && miniBoard[2][2]==2)
            return true;
        else if(miniBoard[0][0]==2 && miniBoard[1][1]==2 && miniBoard[2][2]==2)
            return true;
        else if(miniBoard[0][2]==2 && miniBoard[1][1]==2 && miniBoard[2][0]==2)
            return true;
        else
            return false;
	}
    
	//Post: Returns that the game is a draw.
	public boolean isCatGame() {
        
		for (int i=0; i<3; i++) {
            
			for(int j=0; j<3; j++) {
                
				if (miniBoard[i][j]==0)
					return false;
			}
		}
        
		return true;
	}

	//Pre: There is a miniBoard input to be checked.
	//Post: Returns whether or not the miniBoard has already been marked.
	public boolean isValidminiBoard(int input) {
        
		switch(input) {
                
			case 1: if (miniBoard[0][0] != 0) return false; break;
			case 2: if (miniBoard[0][1] != 0) return false; break;
			case 3: if (miniBoard[0][2] != 0) return false; break;
			case 4: if (miniBoard[1][0] != 0) return false; break;
			case 5: if (miniBoard[1][1] != 0) return false; break;
			case 6: if (miniBoard[1][2] != 0) return false; break;
			case 7: if (miniBoard[2][0] != 0) return false; break;
			case 8: if (miniBoard[2][1] != 0) return false; break;
			case 9: if (miniBoard[2][2] != 0) return false; break;
		}
		
		return true;
	}
	
	public void setPlayerX(boolean in) {
		this.playerX = in;
	}
	
	public void setPlayerO(boolean in) {
		this.playerO = in;
	}

	public void printValidSpots() {
		
		System.out.print("Valid spots are: ");
		// TODO Auto-generated method stub
		if (miniBoard[0][0] == 0) System.out.print("1, ");
		if (miniBoard[0][1] == 0) System.out.print("2, ");
		if (miniBoard[0][2] == 0) System.out.print("3, ");
		if (miniBoard[1][0] == 0) System.out.print("4, ");
		if (miniBoard[1][1] == 0) System.out.print("5, ");
		if (miniBoard[1][2] == 0) System.out.print("6, ");
		if (miniBoard[2][0] == 0) System.out.print("7, ");
		if (miniBoard[2][1] == 0) System.out.print("8, ");
		if (miniBoard[2][2] == 0) System.out.print("9"); 
		
		System.out.println();
	}
	
	public int getNumFilled() {
		int filled = 0;
		for (int i=0; i<3; i++) {
            
			for(int j=0; j<3; j++) {
                
				if (miniBoard[i][j]!=0)
					filled++;
			}
		}
		return filled;
	}
}
