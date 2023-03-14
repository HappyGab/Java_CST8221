package picross;

import java.awt.*;
import java.awt.event.*;

public class GameController  {

	GameModel gameModel;
	GameView gameView;
	
	public GameController(GameModel gameModel, GameView gameView) {
		
		this.gameModel = gameModel;
		this.gameView = gameView;
		
		this.gameView.addGameListener(new GameListener());
		this.gameView.addResetListener(new ResetListener());
	}
	
	class GameListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			gameView.addToControlPanel("pressed");
			System.out.println("y");
		}
		
	}
	
	class ResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int size = gameView.getSizeFromBox();
			gameView.setboardSize(size);
			
		}		
	}
	

}
