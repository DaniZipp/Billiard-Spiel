package Gui;

import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Objects {
	
	private JButton button_1;
	private JButton button_2;
	
	public void init()  {
	
	button_1 = new JButton("Restart");
	button_1.setBackground(new Color (50, 116, 31));
	button_1.setBounds(12, 5, 80, 20);
	
	
	button_2 = new JButton("Physik");
	button_2.setBackground(new Color (50, 116, 31));
	button_2.setBounds(824, 5, 80, 20);
	
	}

	public void showHaupt(JPanel panel){
		panel.add(button_1);
		panel.add(button_2);
			
	}

}