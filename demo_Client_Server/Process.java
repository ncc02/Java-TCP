import java.net.*;
import java.io.*;

public class Process extends Thread{
    Socket soc;

    public Process(Socket soc) {
        this.soc= soc;
    }

    public void run() {
        try{

            BufferedInputStream bis= new BufferedInputStream(new FileInputStream("C:\\Users\\cuong\\OneDrive\\Desktop\\PBL4.txt"));
            BufferedOutputStream bos= new BufferedOutputStream(soc.getOutputStream());
            
            int n;
            while((n= bis.read()) != -1){
                bos.write(n);
            }
            bis.close();
            bos.close();

        }catch(Exception e){}
    }
    
}
