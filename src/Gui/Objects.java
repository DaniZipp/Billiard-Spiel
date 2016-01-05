package Gui;

import java.awt.Color;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Balls.Control;

public class Objects implements ActionListener{
	
	private JButton button_1;
	private JButton button_2;
	
	
	private Control control = null;
	
	public Objects(Control control){
		this.control = control;
	}
	
	public void init()  {
	
	button_1 = new JButton("Restart");
	button_1.setBackground(new Color (50, 116, 31));
	button_1.setBounds(12, 5, 80, 20);
	
	
	button_2 = new JButton("Physik");
	button_2.setBackground(new Color (50, 116, 31));
	button_2.setBounds(824, 5, 80, 20);
	
	
	
	
	button_1.addActionListener(this);
	button_2.addActionListener(this);
	}

	public void showHaupt(JPanel panel){
		panel.add(button_1);
		panel.add(button_2);
		
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button_1) {
			control.setZurücksetzten();
		}
		
		if(e.getSource() == button_2) {
			//noch zu erledigen
		}

	}

}