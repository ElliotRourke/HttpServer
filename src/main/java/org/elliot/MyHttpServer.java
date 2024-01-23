package org.elliot;

import javax.net.ServerSocketFactory;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyHttpServer {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(4)) {
            final SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8080);
            final ConnectionHandler connectionHandler = new ConnectionHandler(socketAddress);

            while (true) {
//                connectionHandler.handleConnection();
            }
        } catch (Exception e) {
            //TODO: handle errors
            e.printStackTrace();
        }
    }
}
