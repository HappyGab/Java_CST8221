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
		JPanel Boardpanel = new JPanel();
		
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
				Boardpanel.add(b[i][i2]);
			}
		}
		Boardpanel.setLayout(new GridLayout(boardRowsCols,boardRowsCols));
		//******************************************************************************************************
		
		JPanel topPanel = new JPanel();
		
		topPanel.setPreferredSize(new Dimension(350,150));
		
		topPanel.setLayout(new BorderLayout());
		
		JPanel top1 = new JPanel();
		top1.setBackground(Color.red);
		top1.setPreferredSize(new Dimension(150,150));
		topPanel.add(top1, BorderLayout.WEST);
		
		JPanel top2 = new JPanel();
		top2.setBackground(Color.orange);
		top2.setPreferredSize(new Dimension(375,150));
		topPanel.add(top2, BorderLayout.CENTER);
		
		JPanel top3 = new JPanel();
		top3.setBackground(Color.pink);
		top3.setPreferredSize(new Dimension(225,150));
		topPanel.add(top3, BorderLayout.EAST);
		
		JPanel WPanel = new JPanel();
		WPanel.setBackground(Color.green);
		WPanel.setPreferredSize(new Dimension(150,425));
		
		JPanel EPanel = new JPanel();
		EPanel.setBackground(Color.blue);
		EPanel.setPreferredSize(new Dimension(225,575));
		
		
		
		game.add(topPanel,BorderLayout.NORTH);
		game.add(WPanel,BorderLayout.WEST);
		game.add(EPanel,BorderLayout.EAST);
		game.add(Boardpanel,BorderLayout.CENTER);
		
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
