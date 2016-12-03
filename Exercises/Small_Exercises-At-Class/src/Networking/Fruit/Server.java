package Networking.Fruit;
import java.awt.List;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import sun.net.www.protocol.http.HttpURLConnection;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

    public static void main(String[] args) throws Exception {
    
    	ArrayList<Fruit> lists = new ArrayList<Fruit>();
    	
       HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
       server.createContext("/Fruits/get", new GetHandler());
       server.createContext("/Fruits/post", new PostHandler());
       server.setExecutor(null); // creates a default executor
       server.start();
    }
}