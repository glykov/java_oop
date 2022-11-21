import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private Vector<ClientHandler> clients;

    public Server() {
        clients = new Vector<>();

        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started... Waiting for client to connect...");
            while (true) {
                Socket incoming = server.accept();
                clients.add(new ClientHandler(this, incoming));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void broadcastMesssage(String message) {
        for (var client : clients) {
            client.sendMessage(message);
        }
    }
}
