package picross;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class GameView extends JFrame{
	
	static JFrame game = new JFrame();
	
	static JPanel northPanel = new JPanel();
	static JPanel westPanel = new JPanel();
	static JPanel eastPanel = new JPanel();
	

	Border labelBorder = BorderFactory.createLineBorder(Color.black);
	
	public void configureNorthPanel() {
		
		northPanel.setLayout(new BorderLayout());
		
		// Logo image ****************************************************************
		JPanel topWest = new JPanel();
		topWest.setPreferredSize(new Dimension(150,150));
		ImageIcon logoImage = new ImageIcon("picrossLogo.png");
		topWest.add(new JLabel(logoImage));
		
		// Columns info panel ********************************************************
		JPanel topCenter = new JPanel();
		topCenter.setPreferredSize(new Dimension(375,150));
		
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
	
	public void configureWestPanel() {
		
		// Columns info panel ********************************************************
		westPanel.setPreferredSize(new Dimension(150,425));
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
	
	public void createGame() {
		
		game.setSize(750,575);
		game.setResizable(false);
		
		game.add(northPanel, BorderLayout.NORTH);
		game.add(westPanel, BorderLayout.WEST);
		game.add(eastPanel, BorderLayout.EAST);
		
		game.setVisible(true);
	}
}
