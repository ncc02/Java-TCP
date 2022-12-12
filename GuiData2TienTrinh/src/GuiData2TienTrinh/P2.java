package GuiData2TienTrinh;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PipedInputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class P2 extends JFrame implements Runnable{
	PipedInputStream pis;
	JLabel l;
	
	public P2(PipedInputStream pis) {
		this.setTitle("Tien trinh 2");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(3);
		this.pis = pis;
		
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
	
		}
		
	}
}
