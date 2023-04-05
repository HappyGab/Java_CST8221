package picross;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

//hello 
import javax.swing.JButton;

public class GameController  {

	GameModel gameModel;
	GameView gameView;
	
	
	public GameController(GameModel gameModel, GameView gameView) {
		
		this.gameModel = gameModel;
		this.gameView = gameView;
		
		this.gameView.addGameListener(new GameListener());
		this.gameView.addResetListener(new ResetListener());   
		this.gameView.addTimerListener(new TimerListener());
	}
	
	private void resetGame() {
		
		this.gameView.addGameListener(new GameListener());
	}
	
	class GameListener implements ActionListener{
		JButton b[][] = gameView.getButtons();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton bClicked = (JButton) e.getSource();
			
			int bX = -1;
			int bY = -1;
			
			int linearValue = -1;
			boolean exit = false;
			
			for (int i=0;i<b.length;i++) {
				if (exit == true) {
					break; 
				}
				
				for (int i2=0;i2<b[i].length;i2++) {
					linearValue++;
					
					if (b[i][i2] == bClicked) {
						bX = i;
						bY = i2;
							
						exit = true; 
						break;
						
					}
				}
			}
			bX++;
			bY++;
			
			if(gameModel.getGameValues().charAt(linearValue) == '0') {
                ((JButton)e.getSource()).setBackground(Color.RED);
            }
            else if (gameModel.getGameValues().charAt(linearValue) == '1') {
                ((JButton)e.getSource()).setBackground(Color.GREEN);
            }
			
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
			String newGame = gameModel.randomGame();
			System.out.println(newGame);
			gameView.timerLabel.setText("00:00");
			String[] newSideLabels = gameModel.sideLabelValues();
			String[][] newTopLabels = gameModel.topLabelValues();
			gameView.setLabelValues(newSideLabels, newTopLabels);
			resetGame();
			gameView.updateComponents();
		}	
	}	
		
	class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			DecimalFormat format = new DecimalFormat("00"); 
			String dSecond; 
			String dMinute; 
			
			gameView.second ++;
		
			if (gameView.second==60) {
				gameView.second = 0;
				gameView.minutes++;
			}
			
			dSecond = format.format(gameView.second); 
			dMinute = format.format(gameView.minutes);
			gameView.timerLabel.setText("" + dMinute +":" + dSecond);
		}
	}
}

