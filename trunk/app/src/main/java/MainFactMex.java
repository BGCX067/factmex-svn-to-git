import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;


public class MainFactMex {
	
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws  FileNotFoundException, IOException {
			MainFactMexForm frame = new MainFactMexForm();
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        Dimension frameSize = frame.getSize();
	        if (frameSize.height > screenSize.height) {
	            frameSize.height = screenSize.height;
	        }
	        if (frameSize.width > screenSize.width) {
	            frameSize.width = screenSize.width;
	        }
	        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setVisible(true);
	        frame.inicia();
	}

}
