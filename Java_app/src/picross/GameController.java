package picross;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


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

