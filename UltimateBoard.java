import java.util.ArrayList;

public class UltimateBoard implements IBoard {
	private TicTacToeBoard[][] UltimateBoard;
	
	private boolean playerX;
	private boolean playerO;
	
	private boolean hasWinner = false;
	//Initialize 9 of the smaller tic tac toe boards in the default constructor
	UltimateBoard(){
		this.UltimateBoard = new TicTacToeBoard[3][3];
		initBoard();
	}
	 // Initialize the boards within the Ultimate Board
    private void initBoard(){
        int counter = 0;
        for(int i = 0; i < UltimateBoard.length; i++){
            for(int j = 0;j<UltimateBoard[i].length;j++){
            	UltimateBoard[i][j] = new TicTacToeBoard(); // create a new Box object for each box in the array.
            }
        }
    }
	@Override
	public void displayBoard() {
		// TODO Auto-generated method stub
		ArrayList<String> strings = new ArrayList<>();
		int counter = 1;
		for(int i = 0; i < UltimateBoard.length; i++){
            for(int j = 0;j<UltimateBoard[i].length;j++){
            	strings.add(UltimateBoard[i][j].getDisplayString()); // create a new Box object for each box in the array.
            	counter++;
            }
        }
		for (int i = 0; i <= strings.size()-3; i += 3) {
			String[] one = strings.get(i).split("\n");
			String[] two = strings.get(i+1).split("\n");
			String[] thr = strings.get(i+2).split("\n");
			
			String[] out = new String[one.length];
			for (int j = 0; j < out.length; j++) {
				out[j] = one[j] + "  " + two[j] + "  " + thr[j];
				System.out.println(out[j]);
			}
			
			
		}
		System.out.println("___________________\n");
	}
	@Override
	public void turn(int UltimateBoard) {
		// TODO Auto-generated method stub
		
	}
	
	public void changePlayer(){
        if(playerX){
            playerX = false;
            playerO = true;
            
        }
        else{
            playerX = true;
            playerO = false;
        }
        
        for(int i = 0;i< UltimateBoard.length;i++){
            for(int j = 0;j<UltimateBoard[i].length;j++){
            	UltimateBoard[i][j].setPlayerX(playerX);
            	UltimateBoard[i][j].setPlayerO(playerO); // create a new Box object for each box in the array.
            }
        }
        
    }  
	
	public boolean isPlayerX() {
		return playerX;
	}

	public boolean xWins() {
		if(UltimateBoard[0][0].xWins() && UltimateBoard[0][1].xWins() && UltimateBoard[0][2].xWins())
            return true;
        else if(UltimateBoard[1][0].xWins() && UltimateBoard[1][1].xWins() && UltimateBoard[1][2].xWins())
            return true;
        else if(UltimateBoard[2][0].xWins() && UltimateBoard[2][1].xWins() && UltimateBoard[2][2].xWins())
            return true;
        else if(UltimateBoard[0][0].xWins() && UltimateBoard[1][0].xWins() && UltimateBoard[2][0].xWins())
            return true;
        else if(UltimateBoard[0][1].xWins() && UltimateBoard[1][1].xWins() && UltimateBoard[2][1].xWins())
            return true;
        else if(UltimateBoard[0][2].xWins() && UltimateBoard[1][2].xWins() && UltimateBoard[2][2].xWins())
            return true;
        else if(UltimateBoard[0][0].xWins() && UltimateBoard[1][1].xWins() && UltimateBoard[2][2].xWins())
            return true;
        else if(UltimateBoard[0][2].xWins() && UltimateBoard[1][1].xWins() && UltimateBoard[2][0].xWins())
            return true;
        else
            return false;
	}
	
	public boolean oWins() {
		if(UltimateBoard[0][0].oWins() && UltimateBoard[0][1].oWins() && UltimateBoard[0][2].oWins())
            return true;
        else if(UltimateBoard[1][0].oWins() && UltimateBoard[1][1].oWins() && UltimateBoard[1][2].oWins())
            return true;
        else if(UltimateBoard[2][0].oWins() && UltimateBoard[2][1].oWins() && UltimateBoard[2][2].oWins())
            return true;
        else if(UltimateBoard[0][0].oWins() && UltimateBoard[1][0].oWins() && UltimateBoard[2][0].oWins())
            return true;
        else if(UltimateBoard[0][1].oWins() && UltimateBoard[1][1].oWins() && UltimateBoard[2][1].oWins())
            return true;
        else if(UltimateBoard[0][2].oWins() && UltimateBoard[1][2].oWins() && UltimateBoard[2][2].oWins())
            return true;
        else if(UltimateBoard[0][0].oWins() && UltimateBoard[1][1].oWins() && UltimateBoard[2][2].oWins())
            return true;
        else if(UltimateBoard[0][2].oWins() && UltimateBoard[1][1].oWins() && UltimateBoard[2][0].oWins())
            return true;
        else
            return false;
	}
	
	//Post: Returns that the game is a draw.
	public boolean isCatGame() {
		if (!xWins() && !oWins()) {
			for (int i=0; i<3; i++) {
	            
				for(int j=0; j<3; j++) {
	                //if a square is not filled or won
					if (!UltimateBoard[i][j].isCatGame() &&  !UltimateBoard[i][j].xWins() && !UltimateBoard[i][j].oWins())
						return false;
				}
			}
			System.out.println("Tied game");
			System.exit(0);
		}
		return false;
	}
	
	public TicTacToeBoard getBoardByNum(int num) {
		int counter = 1;
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if (num == counter) {
					return UltimateBoard[i][j];
				}
				counter++;
			}
		}
		return null;
	}
	
	public void setBoardByNum(TicTacToeBoard board, int num) {
		int counter = 1;
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if (num == counter) {
					UltimateBoard[i][j] = board;
				}
				counter++;
			}
		}
	}

}
