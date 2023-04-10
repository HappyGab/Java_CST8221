package ServerPackage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerView serverUI = new ServerView();
		ServerModel servermodel = new ServerModel();
		ServerController servercontroller = new ServerController(serverUI, servermodel);
		
		serverUI.createServer();
		
	 }
}

/*
Scanner sc = new Scanner(System.in); 

int port; 
String message = ""; 
System.out.println("Enter port: ");

port = sc.nextInt(); 

 ServerSocket server = new ServerSocket(port);
 Socket clientSocket = server.accept();
 
 DataInputStream in = new DataInputStream(System.in);
 DataInputStream is = new DataInputStream(clientSocket.getInputStream());
 DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
 

 

 while(!message.equals("end")) {
	 
	 message =is.readUTF(); 
	 System.out.println("message from client: " + message);
		 
 }

 

	 
	 server.close(); 
	 */