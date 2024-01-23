package org.elliot;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyHttpServer {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        try (ServerSocket serverSocket = new ServerSocket( 8080)) {
            System.out.println("Server started!");
            while (true) {
                executorService.submit(new ConnectionHandler(serverSocket.accept()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
