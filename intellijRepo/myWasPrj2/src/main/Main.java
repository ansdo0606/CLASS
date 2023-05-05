package main;

import com.sun.net.httpserver.HttpServer;
import main.KhHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {


        HttpServer server = HttpServer.create(new InetSocketAddress(8765), 0);
        server.createContext("/kh",new KhHandler());
        server.start();

    }
}