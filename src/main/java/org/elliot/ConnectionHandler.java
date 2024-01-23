package org.elliot;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

public class ConnectionHandler {

    private final SocketAddress socketAddress;

    public ConnectionHandler(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    public void handleConnection() {
        try (ServerSocket serverSocket = new ServerSocket(8080)){
            serverSocket.bind(socketAddress);
            try (InputStream inputStream = serverSocket.accept().getInputStream()) {

            } catch (Exception e) {
                throw new RuntimeException("Inputstream failure!");
            }
        } catch (Exception e) {
            //TODO: handle errors
            e.printStackTrace();
        }
    }
}
