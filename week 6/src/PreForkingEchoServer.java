import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by kevin on 8/3/2019.
 *
 * Echo server capable of handling multiple concurrent client connections.
 * Receives and returns messages from clients.
 */
public class PreForkingEchoServer {
    public static void main(String[] args) throws IOException
    {
       ServerSocket serverSocket = null;
       try{
           serverSocket = new ServerSocket(1337);
           //needed to allow multiple connections, resources need to be released as soon as one connects
           serverSocket.setReuseAddress(true);
           System.out.println("Waiting for connection");
           while(true) {
               Socket clientSocket = serverSocket.accept();
               System.out.println(clientSocket.getInetAddress().getHostAddress() + " connected");


               //serverInstance is a runnable object that will be used to start a thread
               ServerInstance serverInstance = new ServerInstance(clientSocket);
               //each client will be supported by a different thread ("fork")
               Thread thread = new Thread(serverInstance);
               thread.start();
           }
       }
       catch(Exception e) {
           System.out.println("ERROR");
           e.printStackTrace();
       }
       finally {
           if(serverSocket != null) {
               try {
                   serverSocket.close();
               }
               catch(Exception e) {
                   e.printStackTrace();
               }
           }
       }

    }

    //runnable object that can be used to create threads
    private static class ServerInstance implements Runnable {
        private final Socket clientSocket;
        private ServerInstance(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        public void run() {
            //initially define up here so we know in the finally block whether or not to close streams
            //messages returned to client
            PrintWriter out = null;
            //messages received from client
            BufferedReader in = null;
            try {
                out = new PrintWriter(clientSocket.getOutputStream());
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String received;
                while((received = in.readLine()) != null) {
                    System.out.println("Message received from client: " + received);
                    //return message to client
                    out.println(received);
                    out.flush();
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if(out!=null) {
                        out.close();
                    }
                    if(in!=null) {
                        in.close();
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
