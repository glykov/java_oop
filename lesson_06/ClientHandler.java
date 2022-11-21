import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new Scanner(socket.getInputStream());
            this.out = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                while (true) {
                    String line = in.nextLine();
                    System.out.println("client: " + line);
                    if (line.trim().equalsIgnoreCase("/exit")) break;
                    server.broadcastMesssage("client: " + line);
                }
                try {
                    socket.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            
            }).start();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
