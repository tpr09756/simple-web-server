import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Client() throws Exception{
        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successful connection");

        // I/O streams
        BufferedReader inSocket = new BufferedReader(new InputStreamReader((socket.getInputStream())));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = inSocket.readLine();
        System.out.println("Server says " + message);
        outSocket.println("Thanks");

        socket.close();
        System.out.println("Socket closed");
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
