package picross;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;


public class Picross extends JFrame{

	public static void main(String[] args) {
		
		int boardRowsCols = 5; //NEED TO REPLACE WITH VALUE FROM COMBOBOX LATER**********************************
		
		Border rowNcolBorder = BorderFactory.createLineBorder(Color.black);

		JFrame game = new JFrame();
		
		game.setSize(750,575);
		
		JPanel topPanel = new JPanel();
		
		topPanel.setPreferredSize(new Dimension(350,150));
		
		topPanel.setLayout(new BorderLayout());
		
		JPanel top1 = new JPanel();
		top1.setLayout(new BorderLayout());
		top1.setPreferredSize(new Dimension(150,150));
		
		ImageIcon image=new ImageIcon("picrossLogo.png");
		
		String[] languages = {"English","Français"};
		JComboBox<String> languagesBox = new JComboBox<String>(languages);
		
		JButton helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("You clicked ont the help button");		
			}
		});
		helpButton.setPreferredSize(new Dimension(15,15));
		
		top1.add(helpButton, BorderLayout.CENTER);
		top1.add(languagesBox, BorderLayout.SOUTH);
        top1.add(new JLabel(image), BorderLayout.NORTH);
        
		topPanel.add(top1, BorderLayout.WEST);
		
		
		
		JPanel top2 = new JPanel();
		top2.setPreferredSize(new Dimension(375,150));
		
		top2.setLayout(new GridLayout(1,boardRowsCols));
		
		JLabel[] boardCol = new JLabel[boardRowsCols];
		
		for(int i = 0;i<boardRowsCols;i++) {
			
			boardCol[i] = new JLabel("Column " + (i+1));
			boardCol[i].setBorder(rowNcolBorder);
			top2.add(boardCol[i]);
		}
		
		topPanel.add(top2, BorderLayout.CENTER);
		
		JPanel top3 = new JPanel();
		top3.setPreferredSize(new Dimension(225,150));
		
		top3.setLayout(new BorderLayout());
		
		JLabel scoreTracker = new JLabel("score tracker placeholder");
		
		JRadioButton markButton = new JRadioButton("mark");
		
		top3.add(scoreTracker, BorderLayout.NORTH);
		top3.add(markButton, BorderLayout.SOUTH);
		
		topPanel.add(top3, BorderLayout.EAST);
		
		JPanel WPanel = new JPanel();
		
		WPanel.setLayout(new GridLayout(boardRowsCols,1));
		
		JLabel[] boardRow = new JLabel[boardRowsCols];
		
		for(int i = 0;i<boardRowsCols;i++) {
			
			boardRow[i] = new JLabel("Row " + (i+1));
			boardRow[i].setBorder(rowNcolBorder);
			WPanel.add(boardRow[i]);
		}
		
		
		
		WPanel.setPreferredSize(new Dimension(150,425));
		
		JPanel EPanel = new JPanel();
		EPanel.setPreferredSize(new Dimension(225,575));
		
		JTextArea controlPanel = new JTextArea();
		controlPanel.setEditable(false);
		
		JScrollPane controlPanelScroll = new JScrollPane(controlPanel);
		EPanel.add(controlPanelScroll);
		controlPanelScroll.setPreferredSize(new Dimension(225,300));
		controlPanelScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel e2 = new JPanel();
		
		e2.setLayout(new BorderLayout());

		String[] boardSizes = {"5x5","10x10","15x15","20x20"};
		JComboBox<String> boardSizesBox = new JComboBox<String>(boardSizes);
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("You clicked ont the reset button");
				controlPanel.append("Clicked on the reset button\n");				
			}
		});
		
		JLabel timerLabel = new JLabel("Placeholder for timer");
		
		e2.add(timerLabel, BorderLayout.NORTH);
		e2.add(boardSizesBox, BorderLayout.WEST);
		e2.add(resetButton, BorderLayout.EAST);
		
		EPanel.add(e2, BorderLayout.SOUTH);
		
		//CREATES THE GAME BOARD, maybe put in separate function later
				//******************************************************************************************************
				JPanel Boardpanel = new JPanel();
				
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
								controlPanel.append("Clicked on the button at position " + butX + "," + butY + "\n");
							}
						});
						Boardpanel.add(b[i][i2]);
					}
				}
				Boardpanel.setLayout(new GridLayout(boardRowsCols,boardRowsCols));
				//******************************************************************************************************
		
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
