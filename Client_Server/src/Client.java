import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Socket soc=new Socket("169.254.70.82", 2000); server thay
			Socket soc=new Socket("192.168.43.20", 2000);
				
			try {
					BufferedInputStream is = new BufferedInputStream(soc.getInputStream()); 
					BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("C:\\LOL\\mypbl4.txt"));
					System.out.println("is ok");
					
					int s;
					while ((s=is.read())!=-1) {
						os.write(s);
						System.out.println("os ok");
					}
					is.close();
					os.close();
				} catch (Exception e) {
					
				}
		}
		catch(Exception e) {
			
		}
	}

}
