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
	
	private static JTextArea controlPanel = new JTextArea();
	
	public void createMenu() {
		
		this.setSize(750,300);
		this.setResizable(false);
		this.setTitle("Server Options");
		this.setLayout(new GridLayout(3,1,10,10));
		
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
		
		JPanel centerPanel = new JPanel();
		
		controlPanel.setEditable(false);
        JScrollPane controlPanelScrollBar = new JScrollPane(controlPanel);
        controlPanelScrollBar.setPreferredSize(new Dimension(750,200));
        controlPanelScrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.add(northPanel);
		this.add(controlPanelScrollBar);
		this.setVisible(true);
	}
	
	public void addConnectListener(ActionListener listenButton) {
		
		connectButton.addActionListener(listenButton);
	}
}
