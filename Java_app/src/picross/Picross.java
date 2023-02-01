package picross;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;

public class Picross extends JFrame{

	public static void main(String[] args) {

		JFrame game = new JFrame();
		
		game.setSize(750,575);
		
		JPanel panel = new JPanel();
		/*
		JButton b1=new JButton("1");    
		JButton b2=new JButton("2");    
		JButton b3=new JButton("3");    
		JButton b4=new JButton("4");    
		JButton b5=new JButton("5");    
		JButton b6=new JButton("6");    
		JButton b7=new JButton("7");    
		JButton b8=new JButton("8");    
		JButton b9=new JButton("9");
		JButton b10=new JButton("10");
		JButton b11=new JButton("11");
		JButton b12=new JButton("12");
		JButton b13=new JButton("13");
		JButton b14=new JButton("14");
		JButton b15=new JButton("15");
		JButton b16=new JButton("16");    
		JButton b17=new JButton("17");    
		JButton b18=new JButton("18");    
		JButton b19=new JButton("19");
		JButton b20=new JButton("20");
		JButton b21=new JButton("21");
		JButton b22=new JButton("22");
		JButton b23=new JButton("23");
		JButton b24=new JButton("24");
		JButton b25=new JButton("25");
		 // adding buttons to the frame       
		panel.add(b1); panel.add(b2); panel.add(b3);  
		panel.add(b4); panel.add(b5); panel.add(b6);  
		panel.add(b7); panel.add(b8); panel.add(b9); 
		panel.add(b10); panel.add(b11); 
		panel.add(b12); panel.add(b13);  
		panel.add(b14); panel.add(b15); panel.add(b16);  
		panel.add(b17); panel.add(b18); panel.add(b19);
		panel.add(b20); panel.add(b21); 
		panel.add(b22); panel.add(b23);  
		panel.add(b24); panel.add(b25);
		*/
		for(int i = 0;i<9;i++) {
			
			JButton b = new JButton();
			panel.add(b);
		}
		
		panel.setBounds(150,150,375,375);
		
		panel.setLayout(new GridLayout(3,3));
		
		game.add(panel);
		
		game.setLayout(null);
		game.setVisible(true);

	}

}
