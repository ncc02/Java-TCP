import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import javax.xml.crypto.Data;

public class TimSoServer{
    public static void main(String args[]){
        new TimSoServer();
    }

    List<Process> player= new ArrayList<Process>();
    List<Point> dadanh= new ArrayList<Point>();
    Vector<Integer> mau= new Vector<Integer>();
    
    public TimSoServer(){
        try{
            ServerSocket server= new ServerSocket(5000);
            while(true){
                Socket soc= server.accept();
                Process x= new Process(this, soc);
                player.add(x);
                x.start();
            }

        }catch(Exception e){}
    }
}

class Process extends Thread{
    TimSoServer server;
    Socket soc;
    public Process(TimSoServer server, Socket soc){
        this.server= server;
        this.soc=soc;
    }

    public void run(){
        try{
        	DataOutputStream dos= new DataOutputStream(soc.getOutputStream());
    
        	if (server.player.size() > 4) dos.writeUTF("you are a viewer");
        	else dos.writeUTF("you are a player");
        		
        	int i=0;
            for(Point p : server.dadanh){
                dos.writeUTF(p.x+","+p.y+","+server.mau.get(i));
                i++;
            }
        }catch(Exception e){}

        loop:while(true){
            try {
                
                DataInputStream dis = new DataInputStream(soc.getInputStream());
                String s = dis.readUTF();
                int ix = Integer.parseInt(s.split(",")[0]);
                int iy = Integer.parseInt(s.split(",")[1]);
                
                //chi cho phep 4 nguoi choi
                 int imau= 0;
                 for(int i=0; i<Math.min(4, server.player.size()); i++)
                     if (server.player.get(i) == this) imau= i+1;
                 if (imau==0) continue;

                 server.dadanh.add(new Point(ix, iy));
                 server.mau.add(imau);
                
                for (Process x: server.player) {
                        //them diem moi danh cho tat cac client
                        DataOutputStream dos = new DataOutputStream(x.soc.getOutputStream());
                        dos.writeUTF(s+","+imau);
                
                }
            }catch(Exception e1) {}
        }
    }
}