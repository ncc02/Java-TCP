import java.io.*;
import java.net.*;

public class Server{
    public static void main(String args[]) throws IOException{
        
            ServerSocket server= new ServerSocket(2000);
            while(true){
                Socket soc= server.accept();
                new Process(soc).start();
            }
            
    }
}