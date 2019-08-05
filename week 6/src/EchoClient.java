import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kevin on 8/4/2019.
 *
 * Echo client used to test PreForking echo server.
 * Connects to echo server and allows user to send messages to server via stdin.
 * Run multiple instances of this client at once to see the echo server in action.
 */
public class EchoClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 1337;
        try(Socket socket = new Socket(host, port)) {
            System.out.println("Connected to " + host + " on port " + port);
            //messages sent to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //messages being received from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //read input and send to the server until "q" is typed upon which connection will be terminated
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String s = scanner.nextLine();
                if(s.equals("q")){
                    socket.close();
                    break;
                }
                out.println(s);
                out.flush();
                System.out.println("Sent to server: " + s);
                System.out.println("Received from server: " + in.readLine());
            }
            scanner.close();
        }
        catch(Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }



    }
}
