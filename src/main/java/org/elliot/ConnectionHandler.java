package org.elliot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ConnectionHandler {

    private final ServerSocket serverSocket;

    public ConnectionHandler(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void handleConnection() {
            try (
                    Socket client = serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()))
            ) {
                String input;
                String output;

                writer.println("Welcome! You've connected to MyHttpServer!");

                while((input = reader.readLine()) != null) {
                    output = "I have received your input!";
                    writer.println(output);
                }

            } catch (Exception e) {
                throw new RuntimeException("Client failure!", e);
            }
    }
}
