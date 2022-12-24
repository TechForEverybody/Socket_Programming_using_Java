import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 80);
            InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            PrintWriter printwrter = new PrintWriter(client.getOutputStream());
            InputStreamReader console_input=new InputStreamReader(System.in);
            BufferedReader read_console=new BufferedReader(console_input);


            printwrter.println("hello");
            printwrter.flush();
            String message = new String(bufferedReader.readLine());
            System.out.println("server : "+message);
            String input="Hello from client";
            while(input!="quit"){
                input=read_console.readLine();
                printwrter.println(input);
                printwrter.flush();
            }


            client.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}