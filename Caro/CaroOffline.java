
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class CaroOffline extends JFrame implements MouseListener{

	public static void main(String[] args) {
		new CaroOffline();
	}
	int n = 15;
	int s = 30;
	int of = 50;
	List<Point> dadanh = new ArrayList<Point>();
	public CaroOffline() {
		this.setTitle("Co caro");
		this.setSize(n*s+2*of,n*s+2*of);
		this.setDefaultCloseOperation(3);
		this.addMouseListener(this);
		
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.BLACK);
		for (int i=0;i<=n;i++) {
			g.drawLine(of, of + s*i, of+s*n, of + s*i);
			g.drawLine(of + s*i, of, of + s*i, of+s*n);
		}
		g.setFont(new Font("arial",Font.BOLD,s));
		for (int i=0;i<dadanh.size();i++) {
			int x = of+dadanh.get(i).x*s + s - s/2 - s/4;
			int y = of+dadanh.get(i).y*s + s - s/2 + s/4;
			String s = "o";
			if (i%2!=0) s="x";
			g.drawString(s, x, y);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (x<of || x>=of+s*n) return;
		if (y<of || y>=of+s*n) return;
		
		int ix = (x-of)/s;
		int iy = (y-of)/s;
		
		for (Point p : dadanh) {
			if (p.x==ix && p.y==iy) return;
		}
		
		dadanh.add(new Point(ix,iy));
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
