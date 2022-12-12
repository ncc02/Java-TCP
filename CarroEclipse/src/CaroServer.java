import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class CaroServer {
	public static void main(String[] args){
		new CaroServer();
	}
	
	int n= 15;
	List<Point> visited= new ArrayList<Point>();
	List<Process> players= new ArrayList<Process>();
	
	public CaroServer(){
		try {
		ServerSocket server = new ServerSocket(5000);
		while(true) {
			Socket soc = server.accept();
			Process x = new Process(soc, this);			
			
			players.add(x);
			x.start();
		}
		}catch(Exception e) {}
	}
}

class Process extends Thread{
	CaroServer server;
	Socket soc;
	public Process(Socket soc, CaroServer server) {
		this.soc= soc;
		this.server= server;
	}
	
	public void run() {
		for(Point p : server.visited) {
			try {
				DataOutputStream dos= new DataOutputStream(soc.getOutputStream());
				dos.writeUTF(p.x+","+p.y);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
	loop:while(true) {
		try {
		DataInputStream dis= new DataInputStream(soc.getInputStream());
		String s= dis.readUTF();
		
		
		int ix= Integer.parseInt(s.split(",")[0]);
		int iy= Integer.parseInt(s.split(",")[1]);
		
		//neu ko phai nguoi choi 1 va nguoi choi 2 thi out
		if (this != server.players.get(0) && this != server.players.get(1)) continue;
		//luot chan cua nguoi thu nhat, ko phai thi out
		if (server.visited.size()%2 == 0 && this!= server.players.get(0)) continue;
		//luot cua nguoi thu 2, ko phai thi out
		if (server.visited.size()%2 == 1 && this!= server.players.get(1)) continue;
		
		for(Point p: server.visited) {
			if (ix == p.x && iy == p.y) continue loop;
		}
		
		if (ix < 0 || ix >= server.n) continue;
		if (iy < 0 || iy >= server.n) continue;
		
		server.visited.add(new Point(ix, iy));
		
		for(Process x: server.players) {
			DataOutputStream dos = new DataOutputStream(x.soc.getOutputStream());
			dos.writeUTF(s);
		}
		
	}catch(Exception e1) {}
	
}
}
}