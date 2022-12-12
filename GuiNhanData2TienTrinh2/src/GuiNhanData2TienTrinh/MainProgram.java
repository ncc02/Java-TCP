package GuiNhanData2TienTrinh;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class MainProgram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis= new PipedInputStream(pos);
		PipedOutputStream posS = new PipedOutputStream();	
		PipedInputStream pisS= new PipedInputStream(posS);
		
		new P1(pos, pisS);
		new P2(pis, posS);
		
	}

}
