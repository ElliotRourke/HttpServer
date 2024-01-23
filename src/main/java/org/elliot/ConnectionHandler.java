package org.elliot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler implements Runnable {

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
