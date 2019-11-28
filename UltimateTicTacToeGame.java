/*
 This class draws the TicTacToe board and keeps track of the location of all the marks on the board. It also checks for wins and valid spaces 
 and keeps track of whose turn it is. 
 */
public class UltimateTicTacToeGame implements Board {
    
	private static int[][] space = new int[3][3];
	private static boolean playerX = true;
	private static  boolean playerO = false;
	
    //Constructor, creates an empty board.
	public UltimateTicTacToeGame() {
        
		for (int i = 0; i <= 2; i++) {
            
			for (int j = 0; j <= 2; j++) {
                
				space[i][j] = 0;
			}
		}
	}
    
	//Post: Draws the board with pipes and dashes and prints out any marks currently in place.
	public void displayBoard(){
        
        System.out.print("\n");
        for (int i = 0; i <= 2; i++) {
            //Draws empty board
            for (int j = 0; j <= 2; j++) {
                
                if (space[i][j] == 0 && j < 2)
                    System.out.print(" |");
                
                else if (space[i][j] == 0 && j == 2 && i < 2)
                    System.out.print(" \n-----\n");
                
                else if (space[i][j] == 0 && j == 2 && i == 2)
                    System.out.println(" \n");
                
                //Draws board with any X's in the relevant place
                else if (space[i][j] == 1 && j < 2)
                    System.out.print("X|");
                
                else if (space[i][j] == 1 && j == 2 && i < 2) 
                    System.out.print("X\n-----\n");
                
                else if (space[i][j] == 1 && j == 2 && i == 2)
                    System.out.println("X\n");
                
                //Draws board with any O's in the relevant place
                else if (space[i][j] == 2 && j < 2)
                    System.out.print("O|");
                
                else if (space[i][j] == 2 && j == 2 && i < 2)
                    System.out.print("O\n-----\n");
                
                else if (space[i][j] == 2 && j == 2 && i == 2)
                    System.out.println("O\n");
            }
        }
    }
    
	//Pre: There is a board and a player has entered in a space to mark
	//Post: The corresponding space is marked with a 1 or a 2, which translates
	//to an X or an O when read by drawBoard.
	public void turn(int playSpace){
        
        if(playerX){
            switch (playSpace) {
                    
                case 1: space[0][0] = 1; break;
                case 2: space[0][1] = 1; break;
                case 3: space[0][2] = 1; break;
                case 4: space[1][0] = 1; break;
                case 5: space[1][1] = 1; break;
                case 6: space[1][2] = 1; break;
                case 7: space[2][0] = 1; break;
                case 8: space[2][1] = 1; break;
                case 9: space[2][2] = 1; break;
            }
        }
        
        //player O's space
        else{
            
            switch (playSpace) {
                    
                case 1: space[0][0] = 2; break;
                case 2: space[0][1] = 2; break;
                case 3: space[0][2] = 2; break;
                case 4: space[1][0] = 2; break;
                case 5: space[1][1] = 2; break;
                case 6: space[1][2] = 2; break;
                case 7: space[2][0] = 2; break;
                case 8: space[2][1] = 2; break;
                case 9: space[2][2] = 2; break;
            }
        }
    }	
    
    //Pre: There is a space to retrieve.
	//Post: The space is returned.
	public static int getSpace(int i){
		
		switch (i) {
			case 1: return space[0][0];
          	case 2: return space[0][1];
          	case 3: return space[0][2];
          	case 4: return space[1][0];
            case 5: return space[1][1];
          	case 6: return space[1][2];
          	case 7: return space[2][0];
          	case 8: return space[2][1];
          	case 9: return space[2][2];
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
    
    //Post: Returns whose turn it is. Player O is implicitely false.
	public static boolean isPlayerX(){
        
        return playerX;
    }	
    
	//Post: Returns that player X wins if any of the following conditions are met.
	public boolean xWins() {
        
        if(space[0][0]==1 && space[0][1]==1 && space[0][2]==1)
            return true;
        else if(space[1][0]==1 && space[1][1]==1 && space[1][2]==1)
            return true;
        else if(space[2][0]==1 && space[2][1]==1 && space[2][2]==1)
            return true;
        else if(space[0][0]==1 && space[1][0]==1 && space[2][0]==1)
            return true;
        else if(space[0][1]==1 && space[1][1]==1 && space[2][1]==1)
            return true;
        else if(space[0][2]==1 && space[1][2]==1 && space[2][2]==1)
            return true;
        else if(space[0][0]==1 && space[1][1]==1 && space[2][2]==1)
            return true;
        else if(space[0][2]==1 && space[1][1]==1 && space[2][0]==1)
            return true;
        else
            return false;
        
    }
    
	
	//Post: Returns that player O wins if any of the following conditions are met.
	public boolean oWins() {
        
        if(space[0][0]==2 && space[0][1]==2 && space[0][2]==2)
            return true;
        else if(space[1][0]==2 && space[1][1]==2 && space[1][2]==2)
            return true;
        else if(space[2][0]==2 && space[2][1]==2 && space[2][2]==2)
            return true;
        else if(space[0][0]==2 && space[1][0]==2 && space[2][0]==2)
            return true;
        else if(space[0][1]==2 && space[1][1]==2 && space[2][1]==2)
            return true;
        else if(space[0][2]==2 && space[1][2]==2 && space[2][2]==2)
            return true;
        else if(space[0][0]==2 && space[1][1]==2 && space[2][2]==2)
            return true;
        else if(space[0][2]==2 && space[1][1]==2 && space[2][0]==2)
            return true;
        else
            return false;
	}
    
	//Post: Returns that the game is a draw.
	public boolean isCatGame() {
        
		for (int i=0; i<3; i++) {
            
			for(int j=0; j<3; j++) {
                
				if (space[i][j]==0)
					return false;
			}
		}
        
		return true;
	}

	//Pre: There is a space input to be checked.
	//Post: Returns whether or not the space has already been marked.
	public static boolean isValidSpace(int input) {
        
		switch(input) {
                
			case 1: if (space[0][0] != 0) return false; break;
			case 2: if (space[0][1] != 0) return false; break;
			case 3: if (space[0][2] != 0) return false; break;
			case 4: if (space[1][0] != 0) return false; break;
			case 5: if (space[1][1] != 0) return false; break;
			case 6: if (space[1][2] != 0) return false; break;
			case 7: if (space[2][0] != 0) return false; break;
			case 8: if (space[2][1] != 0) return false; break;
			case 9: if (space[2][2] != 0) return false; break;
		}
		
		return true;
	}
}
