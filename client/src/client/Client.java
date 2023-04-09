package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

	public static void main(String[] args)  throws IOException {
	
		Scanner sc = new Scanner(System.in); 
		
		
		String server; 
	    int port;
	    String message; 
	    
	    System.out.println("Enter server: ");
	    server = sc.nextLine(); 
	    System.out.println("Enter Port: ");
	    port = sc.nextInt(); 
	    
		Socket client = new Socket(server, port); 
		
		DataInputStream is = new DataInputStream(client.getInputStream());
		DataOutputStream os = new DataOutputStream(client.getOutputStream());
	
		   System.out.print("client: ");
		   message = sc.next(); 
		   
		   os.writeBytes(message);
		   
		   
	   
	   client.close();

	}

}
