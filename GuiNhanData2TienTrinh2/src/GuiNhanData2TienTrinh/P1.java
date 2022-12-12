package GuiNhanData2TienTrinh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

import javax.swing.*;

public class P1 extends JFrame {
	public P1(PipedOutputStream pos, PipedInputStream pisS) {
		this.setTitle("Tien trinh 1");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(3);
		
		JButton b=new JButton("Send");
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					Random rand= new Random();
					try {
						DataOutputStream dos= new DataOutputStream(pos);
						dos.writeUTF("Toi" + rand.nextInt(100)+"tuoi!");
					}
					catch(Exception e1) {
						
					}
			}
			
		});
		
		
		//Recive
		
		
		JPanel p=new JPanel();
		JLabel l= new JLabel("null");
		JButton bb=new JButton("Recive");
		bb.addActionListener(new ActionListener(){

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
		p.add(bb);
		p.add(l);
		
		
		
		
		
		
		
		
		
		
		
		add(p);
		this.setVisible(true);
	}
}
