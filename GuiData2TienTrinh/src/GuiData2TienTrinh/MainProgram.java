package GuiData2TienTrinh;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class MainProgram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis= new PipedInputStream(pos);
		
		new P1(pos);
		new P2(pis);
	}

}
