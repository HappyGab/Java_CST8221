package picross;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class GameView extends JFrame{
	
	private static JFrame game = new JFrame();
	
	// game components ***************************************************************
	private static JPanel northPanel = new JPanel();
	private static JPanel westPanel = new JPanel();
	private static JPanel eastPanel = new JPanel();
	private static JPanel centerPanel = new JPanel();
	

	Border labelBorder = BorderFactory.createLineBorder(Color.black);
	
	public void configureNorthPanel(int boardSize) {
		
		northPanel.setLayout(new BorderLayout());
		
		// Logo image ****************************************************************
		JPanel topWest = new JPanel();
		topWest.setPreferredSize(new Dimension(150,150));
		ImageIcon logoImage = new ImageIcon("picrossLogo.png");
		topWest.add(new JLabel(logoImage));
		
		// Columns info panel ********************************************************
		JPanel topCenter = new JPanel();
		topCenter.setPreferredSize(new Dimension(375,150));
		topCenter.setLayout(new GridLayout(1,boardSize));
		JLabel[] columnsInfo = new JLabel[boardSize];
		for(int i=0;i<boardSize;i++) {
			
			columnsInfo[i] = new JLabel("column " + (i+1));
			columnsInfo[i].setBorder(labelBorder);
			topCenter.add(columnsInfo[i]);
		}
		
		// Mark button - score *******************************************************
		JPanel topEast = new JPanel();
		topEast.setPreferredSize(new Dimension(225,150));
		topEast.setLayout(new BorderLayout());
		JLabel scoreTracker = new JLabel("score tracker placeholder");
		JRadioButton markButton = new JRadioButton("mark");
		topEast.add(scoreTracker, BorderLayout.NORTH);
		topEast.add(markButton, BorderLayout.SOUTH);
		
		// adding components to north panel ******************************************
		northPanel.add(topWest, BorderLayout.WEST);
		northPanel.add(topCenter, BorderLayout.CENTER);
		northPanel.add(topEast, BorderLayout.EAST);		
		
	}
	
	public void configureWestPanel(int boardSize) {
		
		// Rows info panel ********************************************************
		westPanel.setPreferredSize(new Dimension(150,425));
		westPanel.setLayout(new GridLayout(boardSize, 1));
		JLabel[] rowsInfo = new JLabel[boardSize];
		for(int i=0;i<boardSize;i++) {
			rowsInfo[i] = new JLabel("row " + (i+1));
			rowsInfo[i].setBorder(labelBorder);
			westPanel.add(rowsInfo[i]);
		}
	}
	
	public void configureEastPanel() {
		
		eastPanel.setPreferredSize(new Dimension(225, 575));
		
		// control panel *************************************************************
		JTextArea controlPanel = new JTextArea();
		controlPanel.setEditable(false);
		JScrollPane controlPanelScrollBar = new JScrollPane(controlPanel);
		controlPanelScrollBar.setPreferredSize(new Dimension(225,300));
		controlPanelScrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// Timer - size combo box - reset button *************************************
		JPanel eastSouth = new JPanel();
		eastSouth.setLayout(new BorderLayout());
		JLabel timerLabel = new JLabel("Placeholder for timer");
		String[] boardSizes = {"5x5","10x10","15x15","20x20"};
		JComboBox<String> boardSizeBox = new JComboBox<String>(boardSizes);
		JButton resetButton = new JButton("RESET");
		eastSouth.add(timerLabel, BorderLayout.NORTH);
		eastSouth.add(boardSizeBox, BorderLayout.WEST);
		eastSouth.add(resetButton, BorderLayout.EAST);
		
		// adding components to east Panel
		eastPanel.add(controlPanelScrollBar);
		eastPanel.add(eastSouth, BorderLayout.SOUTH);
	}
	
	public void configureCenterPanel(int boardSize) {
		
		// game board ****************************************************************
		centerPanel.setLayout(new GridLayout(boardSize,boardSize));
		JButton[][] b = new JButton[boardSize][boardSize];
		for (int i=0;i<boardSize;i++) {
			for(int i2=0;i2<boardSize;i2++) {
				b[i][i2] = new JButton();
				centerPanel.add(b[i][i2]);
			}
		}
	}
	
	public void createGame() {
		
		game.setSize(750,575);
		game.setResizable(false);
		
		game.add(northPanel, BorderLayout.NORTH);
		game.add(westPanel, BorderLayout.WEST);
		game.add(eastPanel, BorderLayout.EAST);
		game.add(centerPanel, BorderLayout.CENTER);
		
		game.setVisible(true);
	}
}
