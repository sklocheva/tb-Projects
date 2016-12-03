package Networking.Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Emitter implements Runnable {

	private Socket msocket;

	
	public Emitter(Socket msocket){
		this.msocket = msocket;
	}
	
   public void run() {
			try {
				PrintWriter print = new PrintWriter(this.msocket.getOutputStream(), true);
				Scanner scan = new Scanner(System.in);
				while(true){
				String message = scan.nextLine();
				print.println("Sophie: " + message);
				print.flush();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   }
}
