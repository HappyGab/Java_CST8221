import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in); 
		
		int port; 
		String message = null; 
		
		System.out.println("Enter port: ");
		
		port = sc.nextInt(); 
		
		 ServerSocket server = new ServerSocket(port);
		 Socket clientSocket = server.accept();
		 DataInputStream is = new DataInputStream(clientSocket.getInputStream());
		 DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
		 
	
		 
	
	
		 message =is.readLine(); 
		 
		 System.out.println("message from client: " + message);
		
	
			 
			 server.close(); 
		 }
		 
		 
	}

