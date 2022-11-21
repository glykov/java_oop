import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    private Socket socket;
    private Scanner in;
    private Scanner console;
    private PrintWriter out;

    public Client(String address, int port) {
        try {
            this.socket = new Socket(address, port);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            console = new Scanner(System.in);

            while (true) {
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
                if (console.hasNextLine()) {
                    String line = console.nextLine();
                    out.print(line);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
