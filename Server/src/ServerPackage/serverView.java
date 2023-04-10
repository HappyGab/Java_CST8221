package ServerPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class erverView extends JFrame{

	private static JButton executeButton = new JButton("Execute");
	private static JButton showClientsButton = new JButton("Show Clients");
	private static JButton closeServerButton = new JButton("Terminate Server");
	
	private static JTextArea portNum = new JTextArea(1, 0);
	
	private static JTextArea controlPanel = new JTextArea();
	
	public void createServer() {
		
		this.setSize(750,300);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Server Options");
		this.setLayout(new BorderLayout(10,10));
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,5,10,10));
		
		JLabel portText = new JLabel("Set Port Number:");
		
		top.add(portText);
		top.add(portNum);
		top.add(executeButton);
		top.add(showClientsButton);
		top.add(closeServerButton);
		closeServerButton.setEnabled(false);
		
		controlPanel.setEditable(false);
        JScrollPane controlPanelScrollBar = new JScrollPane(controlPanel);
        controlPanelScrollBar.setPreferredSize(new Dimension(750,200));
        controlPanelScrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.add(top, BorderLayout.CENTER);
		this.add(controlPanelScrollBar, BorderLayout.SOUTH);
		this.setVisible(true);
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
	
	public void addToControlPanel(String text) {
		
		controlPanel.append(text + "\n");
	}
	
	public void toggleExecuteButton() {
		
		if(executeButton.isEnabled()) {
			
			executeButton.setEnabled(false);
		}
		else {
			
			executeButton.setEnabled(true);
		}
	}
	
	public void toggleCloseServerButton() {
		
		if(closeServerButton.isEnabled()) {
			
			closeServerButton.setEnabled(false);
		}
		else {
			
			closeServerButton.setEnabled(true);
		}
	}

	public void addExecuteListener(ActionListener listenButton) {
		
		executeButton.addActionListener(listenButton);
	}
	
	public void addShowClientListener(ActionListener listenButton) {
		
		showClientsButton.addActionListener(listenButton);
	}

	public void addCloseServerListener(ActionListener listenButton) {
	
		closeServerButton.addActionListener(listenButton);
	}
}
