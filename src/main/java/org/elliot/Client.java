package org.elliot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 8080);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                Scanner scanner = new Scanner(System.in);
        ) {
            String serverResponse;
            String userInput;
            while ((serverResponse = reader.readLine()) != null) {
                System.out.println(serverResponse);
                userInput = scanner.next();
                if (userInput != null) {
                    writer.println(userInput);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
