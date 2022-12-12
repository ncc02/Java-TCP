import java.net.*;
import java.io.*;

public class Client{
    public static void main(String args[]) throws UnknownHostException, IOException{
        Socket soc= new Socket("192.168.1.14", 2000);
        
        BufferedInputStream bis= new BufferedInputStream(soc.getInputStream());
        BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream("C:\\LOL\\my_pbl4.txt"));

        int n;
        while( (n=bis.read()) != -1){
            bos.write(n);
        }
        bis.close();
        bos.close();
    }
}
