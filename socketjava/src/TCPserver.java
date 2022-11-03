import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {
    public static void main(String[] args) {
        try {
            ServerSocket severSocket = new ServerSocket(6789);
            System.out.println("listening.....");
            while (true) {
                Socket socket = severSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                String line = reader.readLine();
                System.out.println("received: "+ line);
                out.print(line);
                out.flush();
                System.out.println("Send: "+line.toUpperCase());
                reader.close();
                out.close();
                socket.close();                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}