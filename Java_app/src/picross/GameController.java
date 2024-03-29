package picross;

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;

//hello 
import javax.swing.JButton;

public class GameController  {

	GameModel gameModel;
	GameView gameView;
	clientMenuView clientMenu;
	Socket client; 
	DataInputStream in = new DataInputStream(System.in);
	DataInputStream is ;
	DataOutputStream os;
	
	public GameController(GameModel gameModel, GameView gameView, clientMenuView clientMenu) {
		
		this.gameModel = gameModel;
		this.gameView = gameView;
		this.clientMenu = clientMenu;
		
		this.gameView.addGameListener(new GameListener());
		this.gameView.addResetListener(new ResetListener());   
		this.gameView.addTimerListener(new TimerListener());
		this.gameView.addShowSolutionListener(new showSolutionListener());
		this.gameView.addShowServerOptionsListener(new showServerOptions());
		
		this.clientMenu.addConnectListener(new connectListener());
		this.clientMenu.addDisonnectListener(new disconnectListener());		
		this.clientMenu.addNewGameListener(new NewGameListener());
        this.clientMenu.addSendGameListener(new SendGameListener());
        this.clientMenu.addGetGameListener(new GetGameListener());
        this.clientMenu.addSendDataListener(new SendDataListener());
        this.clientMenu.addPlayListener(new PlayListener());
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
	
	class showServerOptions implements ActionListener{

        public void actionPerformed(ActionEvent e) {

        	clientMenu.toggleVisible();
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
			
			try {
				
			client = new Socket(clientMenu.getServerAddress(), clientMenu.getPort());
		    is = new DataInputStream(client.getInputStream());
			os = new DataOutputStream(client.getOutputStream());
		
		   
			  
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
	class disconnectListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
				String protocal;
	        	protocal =clientMenu.getUserID()+"_0";
	            os.writeUTF(protocal);
				client.close();
				clientMenu.addToControlPanel("client disconnected");		} catch (IOException e1) {

				e1.printStackTrace();
			}	
			
		}
	}
	
	class NewGameListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

        	if(gameView.getFirstGame() == true) {
        		gameView.createGame();
        	}
        	
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
			
			clientMenu.addToControlPanel("New Random Game Generated");
        }
    }

    class SendGameListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {


        	String protocal;
        	protocal =clientMenu.getUserID()+"_1_" + gameModel.getGameValues(); 
        	try {
				os.writeUTF(protocal);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
        }
    }

    class GetGameListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

        	String protocal, replay ;
        	protocal =clientMenu.getUserID()+"_2";
        	try {
				os.writeUTF(protocal);
			
				replay= is.readLine(); 
				String[] data = protocal.split("_"); 
				clientMenu.addToControlPanel(data[1]);
			   
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
        	
        }
    }

    class SendDataListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {


        }
    }

    class PlayListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

        	if(gameView.getFirstGame() == true) {
        		gameView.createGame();
        	}
        	gameView.thisVisible();
        	clientMenu.toggleVisible();
        }
    }
}

