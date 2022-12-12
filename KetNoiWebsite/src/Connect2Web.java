import java.io.DataInputStream;
import java.net.Socket;

public class Connect2Web {

		public static void main(String[] args) {
			try {
				Socket soc= new Socket("169.254.196.104" , 2000);
	
                System.out.println(new DataInputStream(soc.getInputStream()).readUTF());

			}
			catch(Exception e) {}
		}
}