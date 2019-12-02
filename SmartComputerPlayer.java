// Sebastian Moreno SXS170103
/*
 This class contains tools used by smartAI to win the majority of the games, by focusing on wining the smaller games
 mini tic tac toe games and then going in to win the big overall game
 */
import java.util.Random;
public class SmartComputerPlayer extends ComputerPlayer {
    
    public SmartComputerPlayer(boolean isX) {
		super(isX);
		// TODO Auto-generated constructor stub
	}

	int randomInt;
    int turn = 0;
    int ourSymbol;
    int theirSymbol;
    Random generator = new Random();
    
    //Postcondition: Returns a move based on the current condition of the board.
    //Contains the turn counter. 
    public int makeMove(TicTacToeBoard inBoard){
        
    	int filled = inBoard.getNumFilled();
    	if (isX) {
    		turn = filled/2+1;
    	} else {
    		turn = (filled-1)/2+1;
    	}
        //turn++;
        
        //This is turn one. If the  computer goes first it plays the center, otherwise it plays the top left corner.
        if(turn == 1) {
            
            if(inBoard.isValidminiBoard(5))
                   return 5;
            else
                return 1;
        }
        
        //This is turn two.
        if(turn==2) {
            
            if(block(inBoard)!=-1) return block(inBoard);
            
            if(isX)
                ourSymbol = 1;
             else
                  ourSymbol = 2;
            
            if(win(inBoard)!=-1) return win(inBoard);
            else if(block(inBoard)!=-1) return block(inBoard);
            else if(blockFork(inBoard)!=-1) return blockFork(inBoard);
            //return a corner
            else {
                for(int i=0; i<5; i++) {    
                    if(i==1 && inBoard.isValidminiBoard(1))      return 1;
                    else if(i==2 && inBoard.isValidminiBoard(3)) return 3;
                    else if(i==3 && inBoard.isValidminiBoard(7)) return 7;
                    else if(i==4 && inBoard.isValidminiBoard(9)) return 9;
                }
            }
            return -3;
        }
        
        //This is turn 3. It checks for winning moves, blocking moves, and fork blocking moves. 
        if(turn==3) {
            if(win(inBoard)!=-1) return win(inBoard);
            else if(block(inBoard)!=-1) return block(inBoard);
            else if(blockFork(inBoard)!=-1) return blockFork(inBoard);
            else return randomMove(inBoard);
        }
        
        //This is turn 4. It checks for winning moves and blocking moves, other wise it returns a random move. 
        if(turn==4) {
            if(win(inBoard)!=-1) return win(inBoard);
            else if(block(inBoard)!=-1) return block(inBoard);
            else return randomMove(inBoard);
        }
        
        //This is the same as turn 5. 
        if(turn==5) {
            if(win(inBoard)!=-1) return win(inBoard);
            else if(block(inBoard)!=-1) return block(inBoard);
            else return randomMove(inBoard);
        }
        
        return -2;
    }
    
    //Postcondition: Returns the miniBoard necessary to win if it exists. 
    private int win(TicTacToeBoard inBoard) {
        
        if(inBoard.isPlayerX())
            ourSymbol = 1;
        else
            ourSymbol = 2;
        
        //If-Else Statements checks to see if the current player can win the next turn and tells it to make that move.
        if(inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(4)==ourSymbol && inBoard.getminiBoard(7)==0)      return 7;
        else if(inBoard.getminiBoard(2)==ourSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(8)==0) return 8;
        else if(inBoard.getminiBoard(3)==ourSymbol && inBoard.getminiBoard(6)==ourSymbol && inBoard.getminiBoard(9)==0) return 9;
        else if(inBoard.getminiBoard(7)==ourSymbol && inBoard.getminiBoard(4)==ourSymbol && inBoard.getminiBoard(1)==0) return 1;
        else if(inBoard.getminiBoard(8)==ourSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(2)==0) return 2;
        else if(inBoard.getminiBoard(9)==ourSymbol && inBoard.getminiBoard(6)==ourSymbol && inBoard.getminiBoard(3)==0) return 3;
        else if(inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(2)==ourSymbol && inBoard.getminiBoard(3)==0) return 3;
        else if(inBoard.getminiBoard(4)==ourSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(6)==0) return 6;
        else if(inBoard.getminiBoard(7)==ourSymbol && inBoard.getminiBoard(8)==ourSymbol && inBoard.getminiBoard(9)==0) return 9;
        else if(inBoard.getminiBoard(3)==ourSymbol && inBoard.getminiBoard(2)==ourSymbol && inBoard.getminiBoard(1)==0) return 1;
        else if(inBoard.getminiBoard(6)==ourSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(4)==0) return 4;
        else if(inBoard.getminiBoard(9)==ourSymbol && inBoard.getminiBoard(8)==ourSymbol && inBoard.getminiBoard(7)==0) return 7;
        else if(inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(9)==0) return 9;
        else if(inBoard.getminiBoard(3)==ourSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(7)==0) return 7;
        else if(inBoard.getminiBoard(7)==ourSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(3)==0) return 3;
        else if(inBoard.getminiBoard(9)==ourSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(1)==0) return 1;
        else if(inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(3)==ourSymbol && inBoard.getminiBoard(2)==0) return 2;
        else if(inBoard.getminiBoard(4)==ourSymbol && inBoard.getminiBoard(6)==ourSymbol && inBoard.getminiBoard(5)==0) return 5;
        else if(inBoard.getminiBoard(7)==ourSymbol && inBoard.getminiBoard(9)==ourSymbol && inBoard.getminiBoard(8)==0) return 8;
        else if(inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(7)==ourSymbol && inBoard.getminiBoard(4)==0) return 4;
        else if(inBoard.getminiBoard(2)==ourSymbol && inBoard.getminiBoard(8)==ourSymbol && inBoard.getminiBoard(5)==0) return 5;
        else if(inBoard.getminiBoard(3)==ourSymbol && inBoard.getminiBoard(9)==ourSymbol && inBoard.getminiBoard(6)==0) return 6;
        else if(inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(9)==ourSymbol && inBoard.getminiBoard(5)==0) return 5;
        else if(inBoard.getminiBoard(7)==ourSymbol && inBoard.getminiBoard(3)==ourSymbol && inBoard.getminiBoard(5)==0) return 5;
        
        return -1;
    }
    
    // Returns the miniBoard necessary to block the other player from winning if it exists.
    private int block(TicTacToeBoard inBoard) {
        
        if(inBoard.isPlayerX()) 
            theirSymbol = 2;
        else
            theirSymbol = 1;

        //checks to see if the current player needs to play a blocking move to prevent the other player from winning.
        if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(4)==theirSymbol && inBoard.getminiBoard(7)==0)      return 7;
        else if(inBoard.getminiBoard(2)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(8)==0) return 8;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(6)==theirSymbol && inBoard.getminiBoard(9)==0) return 9;
        else if(inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(4)==theirSymbol && inBoard.getminiBoard(1)==0) return 1;
        else if(inBoard.getminiBoard(8)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(2)==0) return 2;
        else if(inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(6)==theirSymbol && inBoard.getminiBoard(3)==0) return 3;
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(2)==theirSymbol && inBoard.getminiBoard(3)==0) return 3;
        else if(inBoard.getminiBoard(4)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(6)==0) return 6;
        else if(inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(8)==theirSymbol && inBoard.getminiBoard(9)==0) return 9;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(2)==theirSymbol && inBoard.getminiBoard(1)==0) return 1;
        else if(inBoard.getminiBoard(6)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(4)==0) return 4;
        else if(inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(8)==theirSymbol && inBoard.getminiBoard(7)==0) return 7;
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(9)==0) return 9;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(7)==0) return 7;
        else if(inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(3)==0) return 3;
        else if(inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(1)==0) return 1;
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(2)==0) return 2;
        else if(inBoard.getminiBoard(4)==theirSymbol && inBoard.getminiBoard(6)==theirSymbol && inBoard.getminiBoard(5)==0) return 5;
        else if(inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(8)==0) return 8;
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(4)==0) return 4;
        else if(inBoard.getminiBoard(2)==theirSymbol && inBoard.getminiBoard(8)==theirSymbol && inBoard.getminiBoard(5)==0) return 5;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(6)==0) return 6;
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(5)==0) return 5;
        else if(inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(5)==0) return 5;
        
        return -1;
    }
    
    //Postcondition:This returns a random move if the other methods don't run.
    private int randomMove(TicTacToeBoard inBoard) {
        
        randomInt = generator.nextInt(9) + 1;
        
         while(!(inBoard.isValidminiBoard(randomInt) && randomInt <= 9 && randomInt >= 1))
              randomInt = generator.nextInt(9) + 1;

         return randomInt;
    }
    
    //Postcondition: This contains a Great Wall that checks for forks and then returns the appropriate miniBoard needed to block the fork.
    private int blockFork(TicTacToeBoard inBoard) {
        
        // special case
        if (inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(3)==0) return 3;
        
        // case1
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(2)==0)      return 2;
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(4)==0) return 4;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(2)==0) return 2;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(2)==0) return 4;
        
        // case 2
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(8)==theirSymbol && inBoard.getminiBoard(4)==0 && inBoard.getminiBoard(7)==0) return 7;
        else if(inBoard.getminiBoard(2)==theirSymbol && inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(4)==0 && inBoard.getminiBoard(1)==0) return 1;
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(6)==theirSymbol && inBoard.getminiBoard(2)==0 && inBoard.getminiBoard(3)==0) return 3;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(4)==theirSymbol && inBoard.getminiBoard(2)==0 && inBoard.getminiBoard(1)==0) return 1;
        else if(inBoard.getminiBoard(2)==theirSymbol && inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(6)==0 && inBoard.getminiBoard(3)==0) return 3;
        else if(inBoard.getminiBoard(4)==theirSymbol && inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(8)==0 && inBoard.getminiBoard(7)==0) return 7;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(8)==theirSymbol && inBoard.getminiBoard(6)==0 && inBoard.getminiBoard(9)==0) return 9;
        else if(inBoard.getminiBoard(6)==theirSymbol && inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(8)==0 && inBoard.getminiBoard(9)==0) return 9;
        
        // case 3
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(9)==ourSymbol && inBoard.getminiBoard(6)==0) return 6;
        else if(inBoard.getminiBoard(1)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(9)==ourSymbol && inBoard.getminiBoard(8)==0) return 8;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(7)==ourSymbol && inBoard.getminiBoard(4)==0) return 4;
        else if(inBoard.getminiBoard(3)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(7)==ourSymbol && inBoard.getminiBoard(8)==0) return 8;
        else if(inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(3)==ourSymbol && inBoard.getminiBoard(2)==0) return 2;
        else if(inBoard.getminiBoard(7)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(3)==ourSymbol && inBoard.getminiBoard(6)==0) return 6;
        else if(inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(2)==0) return 2;
        else if(inBoard.getminiBoard(9)==theirSymbol && inBoard.getminiBoard(5)==theirSymbol && inBoard.getminiBoard(1)==ourSymbol && inBoard.getminiBoard(4)==0) return 4;
        
        // special case
        else if (inBoard.getminiBoard(6)==theirSymbol && inBoard.getminiBoard(8)==theirSymbol && inBoard.getminiBoard(5)==ourSymbol && inBoard.getminiBoard(9)==0) return 9;
        
        return -1;
    }
    //generates the first move of the smart ai based on if it is chosen as the first parameter. AKA PlayerX
    public int firstMove() {
		int fMove;
		fMove = (int)(Math.random() * 9)+1;
		return fMove;
	} 
}
