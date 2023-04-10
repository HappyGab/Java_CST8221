package picross;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;

public class Client {

	
	private int clientNum;
	private String protocal; 
	String server; 
	int port; 
	Socket client; 
	
	Client(String server, int port){
		this.server = "localhost"; 
		this.port = 12345;
		this.clientNum = clientNum;
	}
	
	public void connect()  throws IOException{
		
		client = new Socket(server, port); 	
	}	
	
	public void disconnect() throws IOException {
		
		client.close();
	}

	public void action(JButton button) throws IOException {
		GameModel gameModel = new GameModel();
		GameView gameView = new GameView();
		GameController gameController = new GameController(gameModel, gameView);
		
		DataInputStream in = new DataInputStream(System.in);
		DataInputStream is = new DataInputStream(client.getInputStream());
		DataOutputStream os = new DataOutputStream(client.getOutputStream());
	
		switch (button.getName()) {
		
		case "New game":
		 gameModel.randomGame();
		 
		 
		 
			break; 
			
		case "Send game": 
			
			protocal = clientNum + "#P1#"+ gameModel.getGameValues();
			os.writeUTF(protocal);
			
			break; 
			
		case "Receive game": 
		
			protocal = in.readLine(); 
			
			break; 
			
		case "play":
			
			gameView.createGame();
			
			break;
			
		case "end": 
			
			disconnect(); 
			break; 
			
		
		
		}
		
		
	}
	
}
