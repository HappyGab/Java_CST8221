package picross;

import javax.swing.*;
import java.awt.Color;

public class Picross extends JFrame{

	public static void main(String[] args) {

		JFrame game = new JFrame();
		
		game.setSize(750,575);
		
		
		JLabel topLeft = new JLabel("top left");
		topLeft.setBounds(0,0,150,150);
		topLeft.setBackground(Color.RED);
		topLeft.setOpaque(true);
		
		game.add(topLeft);
		
		game.setLayout(null);
		game.setVisible(true);
		

		
	}

}
