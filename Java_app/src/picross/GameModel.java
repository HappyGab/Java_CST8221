package picross;

public class GameModel {
	
	int boardSize;
	String gameValues;
	
	public GameModel() {
		
		this.boardSize = 5;
		this.gameValues = "0010000100111110111001010";
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
	
	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	

}
