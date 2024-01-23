package org.elliot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class ConnectionHandler {

    private final ServerSocket serverSocket;

    public ConnectionHandler(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void handleConnection() {
            try (Socket client = serverSocket.accept()) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                    System.out.println("Entering");
//                    String line;
//                    while (( line = reader.readLine()) != null) {
//                        System.out.println(line);
//                    }
                    reader
                            .lines()
                            .forEach(System.out::println);
                    System.out.println("Exiting");
                } catch (Exception e) {
                    throw new RuntimeException("Inputstream failure!", e);
                }
            } catch (Exception e) {
                throw new RuntimeException("Client failure!", e);
            }
    }
}
