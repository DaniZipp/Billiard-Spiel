package Gui;

import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Balls.Ball;

public class Objects {
	
	private static JButton button_1;
	private static JButton button_2;
	
	private static JButton button_3;
	private static Ball ball_1;
	
	public static  void init()  {
	
	button_1 = new JButton("Restart");
	button_1.setBackground(new Color (50, 116, 31));
	button_1.setBounds(12, 5, 80, 20);
	
	
	button_2 = new JButton("Physik");
	button_2.setBackground(new Color (50, 116, 31));
	button_2.setBounds(1024, 5, 80, 20);
	
	button_3 = new JButton("Spielstart");
	button_3.setBackground(Color.LIGHT_GRAY);
	button_3.setBounds(12, 5, 100, 20);
	// hier action listener einfügen 
	
	ball_1 = new Ball(100,100);
	}
	

	public static void showHaupt(JPanel panel){
		panel.add(button_1);
		panel.add(button_2);
		panel.add(button_3);
		panel.add(ball_1);
		
		
	}

}