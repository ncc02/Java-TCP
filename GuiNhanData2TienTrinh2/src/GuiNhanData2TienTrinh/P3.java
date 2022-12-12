package GuiNhanData2TienTrinh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

import javax.swing.*;

public class P3 extends JFrame {
	public P3(PipedInputStream pisS) {
		this.setTitle("Tien trinh 3");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(3);
		JPanel p=new JPanel();
		JLabel l= new JLabel("null");
		JButton b=new JButton("Recive");
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
					try {
						DataInputStream dis= new DataInputStream(pisS);
						l.setText(dis.readUTF());
					}
					catch(Exception e1) {
						
					}
				}
			
			
		});
		p.add(b);
		p.add(l);
		
		add(p);
		this.setVisible(true);
	}
}
