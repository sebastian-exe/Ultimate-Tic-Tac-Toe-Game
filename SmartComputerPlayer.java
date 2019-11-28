/*
 This class contains tools used by the cut throat player that allows him to always win. It blocks players from winning, goes for the win,
 blocks forks and goes for the center square if it is left open. A counter is used to keep track of which turn the game is on and it
 uses the appropriate methods.
 */
import java.util.Random;
public class SmartComputerPlayer extends ComputerPlayer {
    
    int randomInt;
    int turn = 0;
    int ourSymbol;
    int theirSymbol;
    Random generator = new Random();
    
    //Postcondition: Returns a move based on the current condition of the board.
    //Contains the turn counter. 
    public int makeMove(){
        
        turn++;
        
        //This is turn one. If the  computer goes first it plays the center, otherwise it plays the top left corner.
        if(turn == 1) {
            
            if(UltimateTicTacToeGame.isValidSpace(5))
                   return 5;
            else
                return 1;
        }
        
        //This is turn two.
        if(turn==2) {
            
            if(block()!=-1) return block();
            
            if(UltimateTicTacToeGame.isPlayerX())
                ourSymbol = 1;
             else
                  ourSymbol = 2;
            
            if(win()!=-1) return win();
            else if(block()!=-1) return block();
            else if(blockFork()!=-1) return blockFork();
            //return a corner
            else {
                for(int i=0; i<5; i++) {    
                    if(i==1 && UltimateTicTacToeGame.isValidSpace(1))      return 1;
                    else if(i==2 && UltimateTicTacToeGame.isValidSpace(3)) return 3;
                    else if(i==3 && UltimateTicTacToeGame.isValidSpace(7)) return 7;
                    else if(i==4 && UltimateTicTacToeGame.isValidSpace(9)) return 9;
                }
            }
            return -3;
        }
        
        //This is turn 3. It checks for winning moves, blocking moves, and fork blocking moves. 
        if(turn==3) {
            if(win()!=-1) return win();
            else if(block()!=-1) return block();
            else if(blockFork()!=-1) return blockFork();
            else return randomMove();
        }
        
        //This is turn 4. It checks for winning moves and blocking moves, other wise it returns a random move. 
        if(turn==4) {
            if(win()!=-1) return win();
            else if(block()!=-1) return block();
            else return randomMove();
        }
        
        //This is the same as turn 5. 
        if(turn==5) {
            if(win()!=-1) return win();
            else if(block()!=-1) return block();
            else return randomMove();
        }
        
        return -2;
    }
    
    //Postcondition: Returns the space necessary to win if it exists. 
    private int win() {
        
        if(UltimateTicTacToeGame.isPlayerX())
            ourSymbol = 1;
        else
            ourSymbol = 2;
        
        //This Great Wall of If-Else Statements checks to see if the current player can win the next turn and tells it to make that move.
        if(UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(4)==ourSymbol && UltimateTicTacToeGame.getSpace(7)==0)      return 7;
        else if(UltimateTicTacToeGame.getSpace(2)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(8)==0) return 8;
        else if(UltimateTicTacToeGame.getSpace(3)==ourSymbol && UltimateTicTacToeGame.getSpace(6)==ourSymbol && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        else if(UltimateTicTacToeGame.getSpace(7)==ourSymbol && UltimateTicTacToeGame.getSpace(4)==ourSymbol && UltimateTicTacToeGame.getSpace(1)==0) return 1;
        else if(UltimateTicTacToeGame.getSpace(8)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(2)==0) return 2;
        else if(UltimateTicTacToeGame.getSpace(9)==ourSymbol && UltimateTicTacToeGame.getSpace(6)==ourSymbol && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        else if(UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(2)==ourSymbol && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        else if(UltimateTicTacToeGame.getSpace(4)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(6)==0) return 6;
        else if(UltimateTicTacToeGame.getSpace(7)==ourSymbol && UltimateTicTacToeGame.getSpace(8)==ourSymbol && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        else if(UltimateTicTacToeGame.getSpace(3)==ourSymbol && UltimateTicTacToeGame.getSpace(2)==ourSymbol && UltimateTicTacToeGame.getSpace(1)==0) return 1;
        else if(UltimateTicTacToeGame.getSpace(6)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(4)==0) return 4;
        else if(UltimateTicTacToeGame.getSpace(9)==ourSymbol && UltimateTicTacToeGame.getSpace(8)==ourSymbol && UltimateTicTacToeGame.getSpace(7)==0) return 7;
        else if(UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        else if(UltimateTicTacToeGame.getSpace(3)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(7)==0) return 7;
        else if(UltimateTicTacToeGame.getSpace(7)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        else if(UltimateTicTacToeGame.getSpace(9)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(1)==0) return 1;
        else if(UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(3)==ourSymbol && UltimateTicTacToeGame.getSpace(2)==0) return 2;
        else if(UltimateTicTacToeGame.getSpace(4)==ourSymbol && UltimateTicTacToeGame.getSpace(6)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==0) return 5;
        else if(UltimateTicTacToeGame.getSpace(7)==ourSymbol && UltimateTicTacToeGame.getSpace(9)==ourSymbol && UltimateTicTacToeGame.getSpace(8)==0) return 8;
        else if(UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(7)==ourSymbol && UltimateTicTacToeGame.getSpace(4)==0) return 4;
        else if(UltimateTicTacToeGame.getSpace(2)==ourSymbol && UltimateTicTacToeGame.getSpace(8)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==0) return 5;
        else if(UltimateTicTacToeGame.getSpace(3)==ourSymbol && UltimateTicTacToeGame.getSpace(9)==ourSymbol && UltimateTicTacToeGame.getSpace(6)==0) return 6;
        else if(UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(9)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==0) return 5;
        else if(UltimateTicTacToeGame.getSpace(7)==ourSymbol && UltimateTicTacToeGame.getSpace(3)==ourSymbol && UltimateTicTacToeGame.getSpace(5)==0) return 5;
        
        return -1;
    }
    
    //Postcondition: Returns the space necessary to block the other player from winning if it exists.
    private int block() {
        
        if(UltimateTicTacToeGame.isPlayerX()) 
            theirSymbol = 2;
        else
            theirSymbol = 1;

        //This Great Wall checks to see if the current player needs to play a blocking move to prevent the other player from winning.
        if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(4)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==0)      return 7;
        else if(UltimateTicTacToeGame.getSpace(2)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==0) return 8;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(6)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        else if(UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(4)==theirSymbol && UltimateTicTacToeGame.getSpace(1)==0) return 1;
        else if(UltimateTicTacToeGame.getSpace(8)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==0) return 2;
        else if(UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(6)==theirSymbol && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==theirSymbol && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        else if(UltimateTicTacToeGame.getSpace(4)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(6)==0) return 6;
        else if(UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==theirSymbol && UltimateTicTacToeGame.getSpace(1)==0) return 1;
        else if(UltimateTicTacToeGame.getSpace(6)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(4)==0) return 4;
        else if(UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==0) return 7;
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==0) return 7;
        else if(UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        else if(UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(1)==0) return 1;
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==0) return 2;
        else if(UltimateTicTacToeGame.getSpace(4)==theirSymbol && UltimateTicTacToeGame.getSpace(6)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==0) return 5;
        else if(UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==0) return 8;
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(4)==0) return 4;
        else if(UltimateTicTacToeGame.getSpace(2)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==0) return 5;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(6)==0) return 6;
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==0) return 5;
        else if(UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==0) return 5;
        
        return -1;
    }
    
    //Postcondition:This returns a random move if the other methods don't run.
    private int randomMove() {
        
        randomInt = generator.nextInt(9) + 1;
        
         while(!(UltimateTicTacToeGame.isValidSpace(randomInt) && randomInt <= 9 && randomInt >= 1))
              randomInt = generator.nextInt(9) + 1;

         return randomInt;
    }
    
    //Postcondition: This contains a Great Wall that checks for forks and then returns the appropriate space needed to block the fork.
    private int blockFork() {
        
        // special case
        if (UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        
        // fork type 1
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==0)      return 2;
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(4)==0) return 4;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==0) return 2;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==0) return 4;
        
        // fork type 2
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==theirSymbol && UltimateTicTacToeGame.getSpace(4)==0 && UltimateTicTacToeGame.getSpace(7)==0) return 7;
        else if(UltimateTicTacToeGame.getSpace(2)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(4)==0 && UltimateTicTacToeGame.getSpace(1)==0) return 1;
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(6)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==0 && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(4)==theirSymbol && UltimateTicTacToeGame.getSpace(2)==0 && UltimateTicTacToeGame.getSpace(1)==0) return 1;
        else if(UltimateTicTacToeGame.getSpace(2)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(6)==0 && UltimateTicTacToeGame.getSpace(3)==0) return 3;
        else if(UltimateTicTacToeGame.getSpace(4)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==0 && UltimateTicTacToeGame.getSpace(7)==0) return 7;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==theirSymbol && UltimateTicTacToeGame.getSpace(6)==0 && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        else if(UltimateTicTacToeGame.getSpace(6)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==0 && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        
        // fork type 3
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==ourSymbol && UltimateTicTacToeGame.getSpace(6)==0) return 6;
        else if(UltimateTicTacToeGame.getSpace(1)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(9)==ourSymbol && UltimateTicTacToeGame.getSpace(8)==0) return 8;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==ourSymbol && UltimateTicTacToeGame.getSpace(4)==0) return 4;
        else if(UltimateTicTacToeGame.getSpace(3)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(7)==ourSymbol && UltimateTicTacToeGame.getSpace(8)==0) return 8;
        else if(UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(3)==ourSymbol && UltimateTicTacToeGame.getSpace(2)==0) return 2;
        else if(UltimateTicTacToeGame.getSpace(7)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(3)==ourSymbol && UltimateTicTacToeGame.getSpace(6)==0) return 6;
        else if(UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(2)==0) return 2;
        else if(UltimateTicTacToeGame.getSpace(9)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==theirSymbol && UltimateTicTacToeGame.getSpace(1)==ourSymbol && UltimateTicTacToeGame.getSpace(4)==0) return 4;
        
        // special case
        else if (UltimateTicTacToeGame.getSpace(6)==theirSymbol && UltimateTicTacToeGame.getSpace(8)==theirSymbol && UltimateTicTacToeGame.getSpace(5)==ourSymbol && UltimateTicTacToeGame.getSpace(9)==0) return 9;
        
        return -1;
    }
}
