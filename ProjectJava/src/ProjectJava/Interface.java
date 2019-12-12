package ProjectJava;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Interface extends Frame {
		
	public Interface() {
		JFrame f = new JFrame();
		f.setTitle("Graphic Interface:");
		f.setSize(1000,1000);
		Choice c = new Choice();
		c.addItem("Client 1");
		c.addItem("Client 2");
		c.addItem("Client 3");
		this.add(c);


		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
		
	public static void main(String args[]) {
		new Interface();
	}
}
