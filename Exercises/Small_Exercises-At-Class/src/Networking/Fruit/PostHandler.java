package Networking.Fruit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import sun.net.www.protocol.http.HttpURLConnection;

public class PostHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange t) throws IOException {
		// post
		
		   InputStream input = t.getRequestBody();
	       BufferedReader in = new BufferedReader(new InputStreamReader(input));
	       StringBuffer response2 = new StringBuffer();
	       String inputLine;
	       
	       while ((inputLine = in.readLine()) != null) {
	    	   response2.append(inputLine);
			}
			in.close();
			System.out.println(response2.toString());
	}

}
