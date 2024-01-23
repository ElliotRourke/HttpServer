package org.elliot;

import java.net.ServerSocket;
import java.net.UnknownHostException;

public class MyHttpServer {
    public static void main(String[] args) throws UnknownHostException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            final ConnectionHandler connectionHandler = new ConnectionHandler(serverSocket);
            while (true) {
                connectionHandler.handleConnection();
            }
        } catch (Exception e) {
            //TODO: handle errors
            e.printStackTrace();
        }
    }
}
