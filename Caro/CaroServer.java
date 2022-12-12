
import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CaroServer {

	public static void main(String[] args) {
		new CaroServer();
	}
	int n = 15;
	Vector<Xuly> cls = new Vector<Xuly>();
	List<Point> dadanh = new ArrayList<Point>();
	public CaroServer() {
		try {
			ServerSocket server = new ServerSocket(5000);
			while (true) {
				Socket soc = server.accept();
				Xuly x = new Xuly(soc,this);
				cls.add(x);
				x.start();
			}

		} catch (Exception e) {

		}	
	}
}

class Xuly extends Thread {
	CaroServer server;
	Socket soc;
	public Xuly(Socket soc,CaroServer server) {
		this.soc = soc;
		this.server = server;
	}
	//cho client da ket noi (soc) co the xem cac nuoc da danh
	public void run() {
		for (Point p : server.dadanh) {
			try{ 
				DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
				dos.writeUTF(p.x+","+p.y);
			}catch (Exception e) {
			}
		}
		
loop:	while (true) { //lang nghe 1 don danh tu client
			try {	
				DataInputStream dis = new DataInputStream(soc.getInputStream());
				String s = dis.readUTF();
				int ix = Integer.parseInt(s.split(",")[0]);
				int iy = Integer.parseInt(s.split(",")[1]);
				if (this!=server.cls.get(0) && this!=server.cls.get(1)) continue;
				if (server.dadanh.size()%2==0 && this!=server.cls.get(0)) continue;
				if (server.dadanh.size()%2==1 && this!=server.cls.get(1)) continue;
				for (Point p:server.dadanh) {
					if (ix==p.x && iy==p.y) continue loop;
				}
				if (ix<0 || ix>=server.n) continue;
				if (iy<0 || iy>=server.n) continue;
				server.dadanh.add(new Point(ix,iy));
				
				for (Xuly x: server.cls) {
					try {
						//them diem moi danh cho tat cac client
						DataOutputStream dos = new DataOutputStream(x.soc.getOutputStream());
						dos.writeUTF(s);
					}catch(Exception e1) {
						
					}
				}
				
			} catch (Exception e) {

			}
		}
	}
}
