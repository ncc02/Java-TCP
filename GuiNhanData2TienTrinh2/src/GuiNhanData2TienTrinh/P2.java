package GuiNhanData2TienTrinh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class P2 extends JFrame implements Runnable{
	PipedInputStream pis;
	JLabel l;
	PipedOutputStream posS;
	
	public P2(PipedInputStream pis, PipedOutputStream posS) {
		this.setTitle("Tien trinh 2");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(3);
		this.pis = pis;
		this.posS= posS;
		
		l= new JLabel("Test");
		this.add(l);
		
		this.setVisible(true);
		new Thread(this).start();
	}

	@Override
	public void run() {
		while(true) {
				DataInputStream dis= new DataInputStream(pis);
				try {
					l.setText(dis.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				DataOutputStream dos= new DataOutputStream(posS);
				try {
					dos.writeUTF("Server tra ve:" + l.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		}
		
	}
}
