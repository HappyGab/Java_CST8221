package ServerPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.Scanner;

public class serverController {

	private serverView serverview;
	private serverModel servermodel;
	
	private ServerSocket server = null;
	
	private Thread serverThread;
	
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
			
			 serverThread = new Thread(new Runnable() {
		            @Override
		            public void run() {
		                try {
		                	while (true) { 
		                        Socket clientSocket = server.accept();
		                        serverview.addToControlPanel("Client connected.");
		                        DataInputStream is = new DataInputStream(clientSocket.getInputStream());
		                        DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

		                        while (true) { 
		                            String protocal = is.readUTF(); 

		                            String[] data = protocal.split("_"); 

		                            switch (data[1]) {
		                            case "0":
		                            	serverview.addToControlPanel(data[0]+" disconnected.");
				                    case "1": 
				                    	servermodel.gamesArr.add(data[2]); 
				                    break;
				                    case "2": 
				                       Random rng = new Random(); 
				                    
				                    os.writeUTF(servermodel.gamesArr.get(rng.nextInt(servermodel.gamesArr.size())));
				                   
				                    	break;
				                    }
		                        }
		                    }
		                }
		            catch (SocketException se) {
		                // The server socket was closed, so exit gracefully
		                return;
		            }catch (IOException e1) {
		                    if (serverThread.isInterrupted()) {
		                        return;
		                    }
		                    e1.printStackTrace();
		                }
		            }
		        });
	        serverThread.start();
	
	        serverview.toggleExecuteButton();
	        serverview.toggleCloseServerButton();
	        serverview.addToControlPanel("Waiting for client connection.");
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
			
			if(serverThread != null) {
				serverThread.interrupt();
			}
	        serverview.addToControlPanel("Server Terminated.");
	        serverview.toggleExecuteButton();	
	        serverview.toggleCloseServerButton();        
			
		}
	}
	
	
}

