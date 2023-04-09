import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class serverView extends JFrame{

	private static JButton executeButton = new JButton("Execute");
	private static JButton showClientsButton = new JButton("Show Clients");
	private static JButton closeServerButton = new JButton("Terminate Server");
	
	private static JTextArea portNum = new JTextArea(1, 0);
	
	private static JTextArea controlPanel = new JTextArea();
	
	public void createServer() {
		
		this.setSize(750,300);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Picross Server");
		this.setLayout(new BorderLayout(10,10));
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,5,10,10));
		
		JLabel portText = new JLabel("Set Port Number:");
		
		top.add(portText);
		top.add(portNum);
		top.add(executeButton);
		top.add(showClientsButton);
		top.add(closeServerButton);
		
		controlPanel.setPreferredSize(new Dimension(750,200));
		this.add(top, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);
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
