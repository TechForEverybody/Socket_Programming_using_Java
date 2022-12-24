import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket sever_Socket = new ServerSocket(80);

            // Socket server = sever_Socket.accept();
            // System.out.println(sever_Socket);
            // System.out.println(server);
            // System.out.println("client is connected");

            // InputStreamReader inputStreamReader = new InputStreamReader(server.getInputStream());
            // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // String message = new String(bufferedReader.readLine());
            // System.out.println("client : " + message);
            // PrintWriter printwrter = new PrintWriter(server.getOutputStream());
            // printwrter.println("hello");
            // printwrter.flush();
            Socket server = sever_Socket.accept();
            System.out.println("client is connected");
            System.out.println(sever_Socket);
            System.out.println(server);
            InputStreamReader inputStreamReader = new InputStreamReader(server.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            PrintWriter printwrter = new PrintWriter(server.getOutputStream());
            // String message = new String(bufferedReader.readLine());
            InputStreamReader console_input=new InputStreamReader(System.in);
            BufferedReader read_console=new BufferedReader(console_input);
            String input="Hello from client";
            while (true) {
                String message = new String(bufferedReader.readLine());
                System.out.println("client : " + message);
                input=read_console.readLine();
                printwrter.println(input);
                printwrter.flush();
                printwrter.println("hello");
                printwrter.flush();
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}