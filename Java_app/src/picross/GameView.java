package picross;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
 
import javax.swing.*;
import javax.swing.border.*;
//hi
public class GameView extends JFrame{
	
	// game components ***************************************************************
	private static JPanel northPanel = new JPanel();
	private static JPanel westPanel = new JPanel();
	private static JPanel eastPanel = new JPanel();
	private static JPanel centerPanel = new JPanel();
	
	
	static Border labelBorder = BorderFactory.createLineBorder(Color.black);
	static JTextArea controlPanel = new JTextArea();
	static int boardSize = 5;
	private static JButton b[][] = new JButton[boardSize][boardSize];
	 static JButton resetButton = new JButton("RESET");
	
	//timer************************************************************************
    static JLabel timerLabel = new JLabel("00:00"); 
    Timer timer; 
    int second; 
    int minutes; 
    
    
    
	static String[] boardSizes = {"5x5","10x10","15x15","20x20"};
	static JComboBox<String> boardSizeBox = new JComboBox<String>(boardSizes);
	
	public void configureNorthPanel() {
		
		northPanel.removeAll();
		
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
	
	public void configureWestPanel() {
		
		westPanel.removeAll();
		
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
		controlPanel.setEditable(false);
		JScrollPane controlPanelScrollBar = new JScrollPane(controlPanel);
		controlPanelScrollBar.setPreferredSize(new Dimension(225,300));
		controlPanelScrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// Timer - size combo box - reset button *************************************
		JPanel eastSouth = new JPanel();
		
		eastSouth.setLayout(new BorderLayout());
		eastSouth.add(timerLabel, BorderLayout.NORTH);
		eastSouth.add(boardSizeBox, BorderLayout.WEST);
		eastSouth.add(resetButton, BorderLayout.EAST);
		
		// adding components to east Panel
		eastPanel.add(controlPanelScrollBar);
		eastPanel.add(eastSouth, BorderLayout.SOUTH);
		
	
	}
	
	public void addResetListener(ActionListener listenButton) {
		
		resetButton.addActionListener(listenButton);
	}
	
	public int getSizeFromBox() {
		
		int index = boardSizeBox.getSelectedIndex();
		int size = 0;
		
		switch (index) {
			case 0:
				size = 5;
				break;
			case 1:
				size = 10;
				break;
			case 2:
				size = 15;
				break;
			case 3:
				size = 20;
				break;
		}
		
		return size;
	}
	
	public void setboardSize(int size) {
		
		boardSize = size;
		b = new JButton[size][size];
	}
	
	public void configureCenterPanel() {
		
		// game board ****************************************************************
		centerPanel.removeAll();
		centerPanel.setLayout(new GridLayout(boardSize,boardSize));
		for (int i=0;i<boardSize;i++) {
			for(int i2=0;i2<boardSize;i2++) {
				b[i][i2] = new JButton();
				centerPanel.add(b[i][i2]);
			}
		}
	}

	public void addGameListener(ActionListener listenButton) {
		configureCenterPanel();
		
		for (int i=0;i<boardSize;i++) {
			for(int i2=0;i2<boardSize;i2++) {
				b[i][i2].addActionListener(listenButton);
			}
		}
	}
	
	public JButton[][] getButtons(){
		return b;
	}
	
	public void addToControlPanel(String text) {
		
		controlPanel.append(text + "\n");
	}
	
	public void updateComponents() {
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(westPanel, BorderLayout.WEST);
		this.add(eastPanel, BorderLayout.EAST);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void createGame() {
		
		configureWestPanel();
		configureNorthPanel();
		configureEastPanel();
		
		updateComponents();
		
		this.setSize(750,575);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}
	
	public void addTimerListener(ActionListener listener) {

		timer = new Timer(1000, listener );
		timer.start();
	}
}