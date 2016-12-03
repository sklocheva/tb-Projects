package Networking.ServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientPart {
	public static void main(String[] args) throws UnknownHostException, IOException {

		while (true) {
			Socket socket = new Socket("localhost", 8008);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String answer = input.readLine();

			System.out.println(answer);
		}
	}
}
