import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;

public class CarroOffline extends JFrame implements MouseListener{
    public static void main(String args[]){
        new CarroOffline();
    }

    int n= 15;
    int s= 30;
    int of= 50;
	List<Point> dadanh = new ArrayList<Point>();
    
    public CarroOffline(){
        this.setTitle("Co caro");
        this.setSize(n*s + 2*of, n*s+2*of);
        this.setDefaultCloseOperation(3);
        this.addMouseListener((MouseListener) this);
        this.setVisible(true);
    }
    
    public void paint(Graphics g) {
    	g.setColor(Color.black);
    	//g.fillRect(0, 0, this.getWidth(), this.)
   
    	for(int i=0; i<=15; i++) {
    		g.drawLine(of, of + s*i, of+s*n, of + s*i);
    		g.drawLine(of+s*i, of, of+s*i, of + s*n);	
    	}
    	
    	g.setFont(new Font("arial", Font.BOLD, s));
    	int cnt= 0;
    	for(Point p: dadanh) {
    		int x = p.x*s + of + 7;
    		int y = p.y*s + of + 22;
    		cnt++;
    		String s= (cnt%2!=0 ? "x" : "o");
    		g.drawString(s, x, y);
    	}
    }
    
    public void mouseClicked(MouseEvent e) {
    	int x= e.getX();
    	int y= e.getY();
    	
    	if (x < of || x > of + s*n) return;
    	if (y < of || y > of + s*n) return;
    	
    	int ix = (x - of) / s;
    	int iy = (y - of) / s;
    	
    	for(Point p : dadanh)
    		if (p.x == ix && p.y == iy) return;
    	
    	dadanh.add(new Point(ix, iy));
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