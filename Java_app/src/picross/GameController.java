package picross;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

//hello 
import javax.swing.JButton;

public class GameController  {

	GameModel gameModel;
	GameView gameView;
	clientMenuView clientMenu;
	
	public GameController(GameModel gameModel, GameView gameView, clientMenuView clientMenu) {
		
		this.gameModel = gameModel;
		this.gameView = gameView;
		this.clientMenu = clientMenu;
		
		this.gameView.addGameListener(new GameListener());
		this.gameView.addResetListener(new ResetListener());   
		this.gameView.addTimerListener(new TimerListener());
		this.gameView.addShowSolutionListener(new showSolutionListener());
		this.clientMenu.addConnectListener(new connectListener());
	}
	
	private void resetGame() {
		
		JButton showSolution = gameView.getShowSolution();		
		showSolution.removeActionListener(showSolution.getActionListeners()[0]);		
		
		this.gameView.addGameListener(new GameListener());
		this.gameView.addShowSolutionListener(new showSolutionListener());
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
			
			boolean markEnabled = gameView.isMarkEnabled();
			
			if(markEnabled == false) {
				if(gameModel.getGameValues().charAt(linearValue) == '0') {
					gameView.changeButtonColor(bX-1,bY-1,"Red");
	                gameView.updateScore(false);

	    			gameView.addToControlPanel("Wrong click at " + bX + "," + bY);
	            }
	            else if (gameModel.getGameValues().charAt(linearValue) == '1') {  	
	            	
	            	gameView.changeButtonColor(bX-1,bY-1,"Green");
	                gameView.updateScore(true);
	                boolean gameOver = gameModel.isGameOver();
	                if(gameOver == true) {
	                	int score = gameView.getScore();
	    				String finalScore = gameModel.getFinalScore(score);
	    				gameView.gameOver(finalScore);
	    			}

	    			gameView.addToControlPanel("Correct click at " + bX + "," + bY);
	            }
				((JButton)e.getSource()).setEnabled(false);
			}
			else {
				gameView.changeButtonColor(bX-1,bY-1,"lightYellow");
			}
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
			gameModel.randomGame();
			gameView.timerLabel.setText("00:00");
			String[] newSideLabels = gameModel.sideLabelValues();
			String[][] newTopLabels = gameModel.topLabelValues();
			gameView.setLabelValues(newSideLabels, newTopLabels);
			gameView.resetScore();
			resetGame();
			gameView.updateComponents();
		}	
	}	
	
	class showSolutionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton b[][] = gameView.getButtons();
			String solution = gameModel.getGameValues();
			int linearIndex = 0;
			
			for (int i=0;i<b.length;i++) {
				for (int i2=0;i2<b[i].length;i2++) {
					
					if(solution.charAt(linearIndex) == '1') {
						
						gameView.changeButtonColor(i,i2,"lightGreen");
					}
					linearIndex++;
				}
			}
			
			gameView.addToControlPanel("Solution revealed");
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
	
	class connectListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
		}
	
	}
}

