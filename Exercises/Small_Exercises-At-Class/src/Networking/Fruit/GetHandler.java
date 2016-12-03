package Networking.Fruit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import sun.net.www.protocol.http.HttpURLConnection;

public class GetHandler implements HttpHandler {
   
    public void handle(HttpExchange t) throws IOException {
    	
       System.out.println(t.getRequestURI().getQuery());
       System.out.println(t.getRequestMethod());
       String response = "";
       t.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
       OutputStream os = t.getResponseBody();
       os.write(response.getBytes());
       os.close();
    }
}