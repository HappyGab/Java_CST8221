import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverController {

	private serverView serverview;
	private serverModel servermodel;
	
	private ServerSocket server = null;
	
	public serverController(serverView serverview, serverModel servermodel) {
		
		this.serverview = serverview;
		this.servermodel = servermodel;
		
		this.serverview.addExecuteListener(new executeListener());
		this.serverview.addShowClientListener(new showClientListener());
		this.serverview.addCloseServerListener(new closeServerListener());
	}
	
	class executeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int port = serverview.getPort();
			
			try {
				server = new ServerSocket(port);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				return;
			}
			try {
				Socket clientSocket = server.accept();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
			}
			
			serverview.addToControlPanel("Client Conncted");
		}
	}
	
	class showClientListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	class closeServerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				server.close();
			} catch (IOException e1) {
				serverview.addToControlPanel("Server Termination Error");
			}
		}
		
	}
}

