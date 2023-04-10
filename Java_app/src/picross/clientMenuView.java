package picross;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;
import javax.swing.border.*;

public class clientMenuView extends JFrame{

	private static JButton connectButton = new JButton("Connect");
	private static JButton disconnectButton = new JButton("Disconnect");
	
	private static JTextArea userID = new JTextArea(1, 0);
	private static JTextArea serverIP = new JTextArea(1, 0);
	private static JTextArea portNum = new JTextArea(1, 0);
	
	private static JButton newGameButton = new JButton("New Game");
	private static JButton sendGameButton = new JButton("Send Game");
	private static JButton getGameButton = new JButton("Receive Game");
	private static JButton sendDataButton = new JButton("Send Data");
	private static JButton playButton = new JButton("Play");
	
	private static JTextArea controlPanel = new JTextArea();
	
	public void createMenu() {
		
		this.setSize(750,300);
		this.setResizable(false);
		this.setTitle("Server Options");
		this.setLayout(new BorderLayout(10,10));
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1,8,10,10));
		
		JLabel userText = new JLabel("User:");
		JLabel serverText = new JLabel("Server:");
		JLabel portText = new JLabel("Port:");
		
		northPanel.add(userText);
		northPanel.add(userID);
		northPanel.add(serverText);
		northPanel.add(serverIP);
		northPanel.add(portText);
		northPanel.add(portNum);
		northPanel.add(connectButton);
		northPanel.add(disconnectButton);
		northPanel.setPreferredSize(new Dimension(750,45));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1,5,10,10));
		centerPanel.add(newGameButton);
		centerPanel.add(sendGameButton);
		centerPanel.add(getGameButton);
		centerPanel.add(sendDataButton);
		centerPanel.add(playButton);
		
		controlPanel.setEditable(false);
        JScrollPane controlPanelScrollBar = new JScrollPane(controlPanel);
        controlPanelScrollBar.setPreferredSize(new Dimension(750,150));
        controlPanelScrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(controlPanelScrollBar, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public String getUserID() {
		
		return userID.getText();
	}
	
	public int getPort() {
		
		String portStr = portNum.getText();
		
		int port = 0;
		
		try {
			port = Integer.parseInt(portStr);
		}
		catch(Exception e) {
			controlPanel.append("Port needs to be a integer\n");
		}
		
		return port;
	}
	
	public String getServerAddress() {
		
		return serverIP.getText();
	}
	
	public void addConnectListener(ActionListener listenButton) {
		
		connectButton.addActionListener(listenButton);
	}
	
	public void addDisonnectListener(ActionListener listenButton) {
		
		disconnectButton.addActionListener(listenButton);
	}
		
	public void addNewGameListener(ActionListener listenButton) {
			
		newGameButton.addActionListener(listenButton);
	}
	
	public void addSendGameListener(ActionListener listenButton) {
		
		sendGameButton.addActionListener(listenButton);
	}
	
	public void addGetGameListener(ActionListener listenButton) {
		
		getGameButton.addActionListener(listenButton);
	}
	
	public void addSendDataListener(ActionListener listenButton) {
		
		sendDataButton.addActionListener(listenButton);
	}
	
	public void addPlayListener(ActionListener listenButton) {
		
		playButton.addActionListener(listenButton);
	}
}
