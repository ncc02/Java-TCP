import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server= new ServerSocket(2000);
			while(true) {
				Socket soc=server.accept();
				//Doc file -> gui
				new Xuly(soc).start();
			}
		}
		catch(Exception e) {}
	}
}


class Xuly extends Thread{
	Socket soc;
	public Xuly(Socket soc) {
		this.soc= soc;
	}
	public void run() {
		try {
			BufferedInputStream is= new BufferedInputStream(new FileInputStream("C:\\Users\\cuong\\OneDrive\\Desktop\\PBL4.txt"));
			BufferedOutputStream os= new BufferedOutputStream(soc.getOutputStream());
			int s;
			while ((s=is.read())!=-1) {
				os.write(s);
				System.out.println("os ok");
			}
			is.close();
			os.close();
		} catch (Exception e) {}
	}
}
