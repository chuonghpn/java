import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPclient {
    public static void main(String[] args) {
        try {
                Socket socket = new Socket("172.0.0.1",6789 );
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                Scanner s = new Scanner(System.in);
                Scanner k = new Scanner(System.in);
                System.out.println("enter a line: ");
                String st = s.nextLine();
                System.out.println("sens: "+st);
                out.println(st);
                out.flush();

                String line = reader.readLine();
                System.out.println("received: "+ line);
                
                reader.close();
                out.close();
                socket.close();                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
