/*
 This class contains tools used by the cut throat player that allows him to always win. It blocks players from winning, goes for the win,
 blocks forks and goes for the center square if it is left open. A counter is used to keep track of which turn the game is on and it
 uses the appropriate methods.
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
            
            if(inBoard.isValidSpace(5))
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
                    if(i==1 && inBoard.isValidSpace(1))      return 1;
                    else if(i==2 && inBoard.isValidSpace(3)) return 3;
                    else if(i==3 && inBoard.isValidSpace(7)) return 7;
                    else if(i==4 && inBoard.isValidSpace(9)) return 9;
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
    
    //Postcondition: Returns the space necessary to win if it exists. 
    private int win(TicTacToeBoard inBoard) {
        
        if(inBoard.isPlayerX())
            ourSymbol = 1;
        else
            ourSymbol = 2;
        
        //This Great Wall of If-Else Statements checks to see if the current player can win the next turn and tells it to make that move.
        if(inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(4)==ourSymbol && inBoard.getSpace(7)==0)      return 7;
        else if(inBoard.getSpace(2)==ourSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(8)==0) return 8;
        else if(inBoard.getSpace(3)==ourSymbol && inBoard.getSpace(6)==ourSymbol && inBoard.getSpace(9)==0) return 9;
        else if(inBoard.getSpace(7)==ourSymbol && inBoard.getSpace(4)==ourSymbol && inBoard.getSpace(1)==0) return 1;
        else if(inBoard.getSpace(8)==ourSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(2)==0) return 2;
        else if(inBoard.getSpace(9)==ourSymbol && inBoard.getSpace(6)==ourSymbol && inBoard.getSpace(3)==0) return 3;
        else if(inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(2)==ourSymbol && inBoard.getSpace(3)==0) return 3;
        else if(inBoard.getSpace(4)==ourSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(6)==0) return 6;
        else if(inBoard.getSpace(7)==ourSymbol && inBoard.getSpace(8)==ourSymbol && inBoard.getSpace(9)==0) return 9;
        else if(inBoard.getSpace(3)==ourSymbol && inBoard.getSpace(2)==ourSymbol && inBoard.getSpace(1)==0) return 1;
        else if(inBoard.getSpace(6)==ourSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(4)==0) return 4;
        else if(inBoard.getSpace(9)==ourSymbol && inBoard.getSpace(8)==ourSymbol && inBoard.getSpace(7)==0) return 7;
        else if(inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(9)==0) return 9;
        else if(inBoard.getSpace(3)==ourSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(7)==0) return 7;
        else if(inBoard.getSpace(7)==ourSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(3)==0) return 3;
        else if(inBoard.getSpace(9)==ourSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(1)==0) return 1;
        else if(inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(3)==ourSymbol && inBoard.getSpace(2)==0) return 2;
        else if(inBoard.getSpace(4)==ourSymbol && inBoard.getSpace(6)==ourSymbol && inBoard.getSpace(5)==0) return 5;
        else if(inBoard.getSpace(7)==ourSymbol && inBoard.getSpace(9)==ourSymbol && inBoard.getSpace(8)==0) return 8;
        else if(inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(7)==ourSymbol && inBoard.getSpace(4)==0) return 4;
        else if(inBoard.getSpace(2)==ourSymbol && inBoard.getSpace(8)==ourSymbol && inBoard.getSpace(5)==0) return 5;
        else if(inBoard.getSpace(3)==ourSymbol && inBoard.getSpace(9)==ourSymbol && inBoard.getSpace(6)==0) return 6;
        else if(inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(9)==ourSymbol && inBoard.getSpace(5)==0) return 5;
        else if(inBoard.getSpace(7)==ourSymbol && inBoard.getSpace(3)==ourSymbol && inBoard.getSpace(5)==0) return 5;
        
        return -1;
    }
    
    //Postcondition: Returns the space necessary to block the other player from winning if it exists.
    private int block(TicTacToeBoard inBoard) {
        
        if(inBoard.isPlayerX()) 
            theirSymbol = 2;
        else
            theirSymbol = 1;

        //This Great Wall checks to see if the current player needs to play a blocking move to prevent the other player from winning.
        if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(4)==theirSymbol && inBoard.getSpace(7)==0)      return 7;
        else if(inBoard.getSpace(2)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(8)==0) return 8;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(6)==theirSymbol && inBoard.getSpace(9)==0) return 9;
        else if(inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(4)==theirSymbol && inBoard.getSpace(1)==0) return 1;
        else if(inBoard.getSpace(8)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(2)==0) return 2;
        else if(inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(6)==theirSymbol && inBoard.getSpace(3)==0) return 3;
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(2)==theirSymbol && inBoard.getSpace(3)==0) return 3;
        else if(inBoard.getSpace(4)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(6)==0) return 6;
        else if(inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(8)==theirSymbol && inBoard.getSpace(9)==0) return 9;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(2)==theirSymbol && inBoard.getSpace(1)==0) return 1;
        else if(inBoard.getSpace(6)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(4)==0) return 4;
        else if(inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(8)==theirSymbol && inBoard.getSpace(7)==0) return 7;
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(9)==0) return 9;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(7)==0) return 7;
        else if(inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(3)==0) return 3;
        else if(inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(1)==0) return 1;
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(2)==0) return 2;
        else if(inBoard.getSpace(4)==theirSymbol && inBoard.getSpace(6)==theirSymbol && inBoard.getSpace(5)==0) return 5;
        else if(inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(8)==0) return 8;
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(4)==0) return 4;
        else if(inBoard.getSpace(2)==theirSymbol && inBoard.getSpace(8)==theirSymbol && inBoard.getSpace(5)==0) return 5;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(6)==0) return 6;
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(5)==0) return 5;
        else if(inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(5)==0) return 5;
        
        return -1;
    }
    
    //Postcondition:This returns a random move if the other methods don't run.
    private int randomMove(TicTacToeBoard inBoard) {
        
        randomInt = generator.nextInt(9) + 1;
        
         while(!(inBoard.isValidSpace(randomInt) && randomInt <= 9 && randomInt >= 1))
              randomInt = generator.nextInt(9) + 1;

         return randomInt;
    }
    
    //Postcondition: This contains a Great Wall that checks for forks and then returns the appropriate space needed to block the fork.
    private int blockFork(TicTacToeBoard inBoard) {
        
        // special case
        if (inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(3)==0) return 3;
        
        // fork type 1
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(2)==0)      return 2;
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(4)==0) return 4;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(2)==0) return 2;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(2)==0) return 4;
        
        // fork type 2
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(8)==theirSymbol && inBoard.getSpace(4)==0 && inBoard.getSpace(7)==0) return 7;
        else if(inBoard.getSpace(2)==theirSymbol && inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(4)==0 && inBoard.getSpace(1)==0) return 1;
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(6)==theirSymbol && inBoard.getSpace(2)==0 && inBoard.getSpace(3)==0) return 3;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(4)==theirSymbol && inBoard.getSpace(2)==0 && inBoard.getSpace(1)==0) return 1;
        else if(inBoard.getSpace(2)==theirSymbol && inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(6)==0 && inBoard.getSpace(3)==0) return 3;
        else if(inBoard.getSpace(4)==theirSymbol && inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(8)==0 && inBoard.getSpace(7)==0) return 7;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(8)==theirSymbol && inBoard.getSpace(6)==0 && inBoard.getSpace(9)==0) return 9;
        else if(inBoard.getSpace(6)==theirSymbol && inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(8)==0 && inBoard.getSpace(9)==0) return 9;
        
        // fork type 3
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(9)==ourSymbol && inBoard.getSpace(6)==0) return 6;
        else if(inBoard.getSpace(1)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(9)==ourSymbol && inBoard.getSpace(8)==0) return 8;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(7)==ourSymbol && inBoard.getSpace(4)==0) return 4;
        else if(inBoard.getSpace(3)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(7)==ourSymbol && inBoard.getSpace(8)==0) return 8;
        else if(inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(3)==ourSymbol && inBoard.getSpace(2)==0) return 2;
        else if(inBoard.getSpace(7)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(3)==ourSymbol && inBoard.getSpace(6)==0) return 6;
        else if(inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(2)==0) return 2;
        else if(inBoard.getSpace(9)==theirSymbol && inBoard.getSpace(5)==theirSymbol && inBoard.getSpace(1)==ourSymbol && inBoard.getSpace(4)==0) return 4;
        
        // special case
        else if (inBoard.getSpace(6)==theirSymbol && inBoard.getSpace(8)==theirSymbol && inBoard.getSpace(5)==ourSymbol && inBoard.getSpace(9)==0) return 9;
        
        return -1;
    }
    
    public int firstMove() {
		int fMove;
		fMove = (int)(Math.random() * 9)+1;
		return fMove;
	} 
}
