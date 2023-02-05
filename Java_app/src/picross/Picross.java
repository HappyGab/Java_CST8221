package picross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Picross extends JFrame{

	public static void main(String[] args) {

		JFrame game = new JFrame();
		
		game.setSize(750,575);
		
		//CREATES THE GAME BOARD, maybe put in separate function later
		//******************************************************************************************************
		JPanel panel = new JPanel();
		
		int boardRowsCols = 5; //NEED TO REPLACE WITH VALUE FROM COMBOBOX LATER**********************************
		
		boardButton[][] b = new boardButton[boardRowsCols][boardRowsCols];
		
		for(int i = 0;i<boardRowsCols;i++) {
			for(int i2 = 0;i2<boardRowsCols;i2++) {
				b[i][i2] = new boardButton(i,i2);
				b[i][i2].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
							
						boardButton button = (boardButton) e.getSource();
						
						int butX = button.getXPosition();
						int butY = button.getYPosition();
						
						System.out.println("You clicked ont the button at position " + butX + "," + butY);
					}
				});
				panel.add(b[i][i2]);
			}
		}
		panel.setLayout(new GridLayout(boardRowsCols,boardRowsCols));
		//******************************************************************************************************
		
		
		
		panel.setBounds(150,150,375,375);
		
		
		game.add(panel);
		
		game.setLayout(null);
		game.setVisible(true);

	}
	
	public static class boardButton extends JButton{
		
		private int xPosition;
		private int yPosition;
		
		public boardButton(int x, int y) {
			
			this.xPosition = x + 1;
			this.yPosition = y + 1;
		}
		
		public int getXPosition() {
			return xPosition;
		}
		public void setXPosition(int x) {
			this.xPosition = x;
		}
		public int getYPosition() {
			return yPosition;
		}
		public void setYPosition(int y) {
			this.yPosition = y;
		}
	}

}
