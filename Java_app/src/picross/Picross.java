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
		
		JLabel topRight = new JLabel("top right");
		JLabel top = new JLabel("top ");
		JLabel right = new JLabel("right");
		JLabel mid = new JLabel("middle");
		JLabel left = new JLabel("left");
		JLabel bottomRight = new JLabel("timer");
		
		topRight.setBounds(585, 0, 150, 150);
		topRight.setBackground(Color.blue);
		topRight.setOpaque(true);
		game.add(topRight);

		top.setBounds(150, 0, 580, 150);
		top.setBackground(Color.GRAY);
		top.setOpaque(true);
		game.add(top);
		
		right.setBounds(0, 150, 150, 600);
		right.setBackground(Color.green);
		right.setOpaque(true);
		game.add(right);
		
		left.setBounds(585, 150, 150, 600);
		left.setBackground(Color.CYAN);
		left.setOpaque(true);
		game.add(left);
		
		mid.setBounds(150, 150, 600, 600);
		mid.setBackground(Color.yellow);
		mid.setOpaque(true);
		game.add(mid);
		
		bottomRight.setBounds(585, 500, 150, 100);
		bottomRight.setBackground(Color.orange);
		bottomRight.setOpaque(true);
		game.add(bottomRight);
	}

}
