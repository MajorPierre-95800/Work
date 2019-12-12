package ProjectJava;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JButton;
//import java.awt.geom.Line2D;
//import javax.swing.*;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;


public class Interface extends JFrame{

	public Interface() {
		
		//Initialization of my interface
		JFrame f = new JFrame();
		f.setTitle("Assignement EE402");
		f.setSize(750,750);
		f.setLocationRelativeTo(null);
		
		//Color definition of my interface
		JPanel p = new JPanel();
		p.setBackground(Color.DARK_GRAY);
		f.setContentPane(p);
		
		
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main (String[] args) {
		
		new Interface();
	}
}
