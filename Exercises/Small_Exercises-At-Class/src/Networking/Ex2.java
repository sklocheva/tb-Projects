package Networking;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Ex2 {

	public static void main(String[] args) {
		System.out.println(ping("www.javaworld.com",80));
		getLocalIpAddress();
		try {
			downloadURL(new URL("https://pbs.twimg.com/profile_images/562466745340817408/_nIu8KHX.jpeg"), "kitten.jpg");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean ping(String address, int port){
		
		boolean isReachable = true;
		
		try{
			new Socket(address,port);
			
		} catch(UnknownHostException e){
			e.printStackTrace();
			isReachable = false;
		}catch(IOException e){
//			System.out.println(e);
			e.printStackTrace();
			isReachable = false;
		} 
		return isReachable;
	}
	
	private static void getLocalIpAddress(){
		Enumeration<NetworkInterface> en;
			try {
				en = NetworkInterface.getNetworkInterfaces();
				while(en.hasMoreElements()){
					NetworkInterface i = en.nextElement();
					System.out.println(i.toString());
				}
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	private static void downloadURL(URL location, String filename){
		InputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			
			in = new BufferedInputStream(location.openStream());
			out = new ByteArrayOutputStream();
			
			byte[] buff = new byte[2048];
			int n = 0;
			
			while((n = in.read(buff)) != -1){
				out.write(buff, 0, n);
			}
			out.close();
			in.close();
			byte[] response = out.toByteArray();
			
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(response);
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
