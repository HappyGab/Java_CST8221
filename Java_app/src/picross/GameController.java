package picross;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;

public class GameController  {

	GameModel gameModel;
	GameView gameView;
	
	public GameController(GameModel gameModel, GameView gameView) {
		
		this.gameModel = gameModel;
		this.gameView = gameView;
		
		this.gameView.addGameListener(new GameListener());
		this.gameView.addResetListener(new ResetListener());
	}
	
	private void resetGame() {
		
		this.gameView.addGameListener(new GameListener());
	}
	
	class GameListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton b[][] = gameView.getButtons();
			
			JButton bClicked = (JButton) e.getSource();
			
			int bX = -1;
			int bY = -1;
			
			for (int i=0;i<b.length;i++) {
				for (int i2=0;i2<b[i].length;i2++) {
					if (b[i][i2] == bClicked) {
						bX = i;
						bY = i2;
						break;
					}
				}
			}
			bX++;
			bY++;
				
			gameView.addToControlPanel("pressed at " + bX + "," + bY);
		}
	}
	
	class ResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int size = gameView.getSizeFromBox();
			gameView.setboardSize(size);
			gameModel.setBoardSize(size);
			gameView.configureCenterPanel();
			gameView.configureNorthPanel(); 
			gameView.configureWestPanel();
			resetGame();
			gameView.updateComponents();
		}		
	}
}
