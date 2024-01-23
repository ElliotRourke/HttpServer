package org.elliot;

import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket( 8080)) {
            System.out.println("Server started!");
            while (true) {
                new ConnectionHandler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
