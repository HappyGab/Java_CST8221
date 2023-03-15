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
	
	public String[] sideLabelValues() {
		
		int linearIndex = -1;
		int sequence = 0;
		
		String labelValues[] = new String[boardSize];
		
		for(int i=0;i<boardSize;i++) {
						
			for(int i2=0;i2<boardSize;i2++) {
				
				linearIndex++;
				
				if(gameValues.charAt(linearIndex) == '1') {
					
					sequence++;
				}
				else {
					
					if(sequence > 0) {
						
						if(labelValues[i] == null) {
							labelValues[i] = "	" + sequence;							
						}
						else {
							
							labelValues[i] = labelValues[i] + " " + sequence;
						}
					}
					sequence = 0;
					
				}
			}
			
			if(sequence > 0) {
				
				if(labelValues[i] == null) {
					labelValues[i] = "	" + sequence;							
				}
				else {
					
					labelValues[i] = labelValues[i] + " " + sequence;
				}
			}
			
			sequence = 0;
		}
		
		return labelValues;
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
