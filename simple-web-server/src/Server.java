import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2020); //opening new port
        System.out.println("port 2020 opened");
        Socket socket = serverSocket.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected");

        // I/O
        BufferedReader inSocket = new BufferedReader(new InputStreamReader((socket.getInputStream())));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        outSocket.println("Welcome");
        String message = inSocket.readLine();
        System.out.println("Client says: " + message);

        socket.close();
        System.out.println("socket is closed");
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
