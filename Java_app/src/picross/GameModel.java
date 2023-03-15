package picross;

public class GameModel {
	
	int boardSize;
	static String gameValues;
	
	public GameModel() {
		
		boardSize = 5;
		gameValues = "0010000100111110111001010";
	}

	public String randomGame() {
		
		String solution = "";
		
		for(int i=0;i<boardSize;i++) {
			for(int i2=0;i2<boardSize;i2++) {
				int randomNum = (int) Math.round(Math.random());
				solution = solution + randomNum;
			}
		}
		
		gameValues = solution;
		
		return solution;
	}
	
	public static boolean zeroOrOne(int index){
       // char c = gameValues.charAt(index);
        
       
 
        if(Character.compare(gameValues.charAt(index), '1') == 0){
            return true;
        }else{
            return false;
        }
    }
	
	public String getGameValues() {
		
		return gameValues;
	}
	
	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	

}
