package Networking.ServerClient;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerPart {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8008);
		
		while (true) {
			Socket socket = serverSocket.accept();
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			
			Scanner scan = new Scanner(System.in);
			
			String message = scan.nextLine();
			writer.println(message);
		}
	
		

	}

}
