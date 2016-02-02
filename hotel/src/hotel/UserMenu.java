package hotel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UserMenu extends JFrame {

	UserMenu(){

	UserPanel panel = new UserPanel();
	add(panel);
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setVisible(true);
	}
}
