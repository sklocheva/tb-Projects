package Networking.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
	
   private Thread receiverThread;
   private Thread emitterThread;

   public void start() throws UnknownHostException, IOException {
	   
	   Socket msocket = new Socket("10.27.116.182", 8080);
	   
      try {
         receiverThread = new Thread(new Receiver(msocket));
         emitterThread = new Thread(new Emitter(msocket));

         receiverThread.start();
         emitterThread.start();
         
      } catch (Exception e) {
         // handle exception
      } finally {
			// something important
		}
   }

   public void stop() throws IOException {
      receiverThread.interrupt();
      emitterThread.interrupt();
   }
}