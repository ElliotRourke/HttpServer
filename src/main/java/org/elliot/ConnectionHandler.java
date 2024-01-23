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

public class ConnectionHandler extends Thread {

    private final Socket client;

    public ConnectionHandler(Socket client) {
        this.client = client;
    }

    private void handleConnection() {
            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true)
            ) {
                String input;
                String output;

                writer.println("Welcome! You've connected to MyHttpServer!");

                while((input = reader.readLine()) != null) {
                    output = "I have received your input!";
                    writer.println(output);
                    if ("shutdown".equalsIgnoreCase(input)) {
                        writer.println("Goodbye!");
                        break;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("Client failure!", e);
            }
    }

    @Override
    public void run() {
        handleConnection();
    }
}
