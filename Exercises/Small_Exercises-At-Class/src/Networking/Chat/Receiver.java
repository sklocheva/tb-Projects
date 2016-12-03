package Networking.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import com.sun.corba.se.spi.activation.Server;

public class Receiver implements Runnable {

	private Socket msocket;
	
	public Receiver(Socket msocket){
		this.msocket = msocket;
	}
	
   public void run() {
//	   Scanner scan = new Scanner(System.out);
	   BufferedReader input;
		try {
			input = new BufferedReader(new InputStreamReader(this.msocket.getInputStream()));
			while(true){
				   String answer = input.readLine();
				   System.out.println(answer);			
			   }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   }
}
