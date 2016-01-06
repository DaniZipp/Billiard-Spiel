package Gui;

import java.awt.Color;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Balls.Control;

public class Objects implements ActionListener{
	
	private JButton restart;
	private JButton physic;
	private JButton input;
	private JTextField winkel_textfield;
	private JTextField power_textfield;
	private JLabel		power_text;
	private JLabel		winkel_text;
	private JLabel		output_text;
	private int kraft;
	private int winkel;
	
	private Control control = null;
	
	public Objects(Control control){
		this.control = control;
	}
	
	public void init()  {
	
	restart = new JButton("Restart");
	restart.setBackground(new Color (50, 116, 31));
	restart.setBounds(12, 5, 80, 20);
	
	physic = new JButton("Physik");
	physic.setBackground(new Color (50, 116, 31));
	physic.setBounds(824, 5, 80, 20);
	
	input = new JButton("Eingabe");
	input.setBackground(new Color (50, 116, 31));
	input.setBounds(940, 5, 80, 20);
	
	
	restart.addActionListener(this);
	physic.addActionListener(this);
	input.addActionListener(this);
	
	winkel_textfield  = new JTextField();
	winkel_textfield.setBackground(Color.WHITE);
	winkel_textfield.setBounds(850, 180, 150, 30);
	
	power_textfield = new JTextField();
	power_textfield.setBackground(Color.WHITE);
	power_textfield.setBounds(850, 95, 150, 30);
		
	power_text = new JLabel("Kraft");
	power_text.setBounds(850, 140, 150, 40);
	
	output_text = new JLabel("");
	output_text.setBounds(840, 230, 400, 40);
	

	winkel_text = new JLabel("Winkel");
	winkel_text.setBounds(850, 55, 150, 40);
	
	}

	public void showFields(JPanel panel){
		panel.add(restart);
		panel.add(physic);
		panel.add(input);
		panel.add(winkel_textfield);
		panel.add(power_textfield);
		panel.add(power_text);
		panel.add(winkel_text);
		panel.add(output_text);
		
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == restart) {
			control.setZurücksetzten();
		}
		if(e.getSource() == physic) {
			//noch zu erledigen
		}
		if(e.getSource() == input) {
			try{
				output_text.setText("");
				kraft = (Integer.parseInt(winkel_textfield.getText()));
				winkel = (Integer.parseInt(power_textfield.getText()));
			}catch(Exception x){
				output_text.setText("Geben Sie eine Zahl ein oder füllen Sie bitte beider Felder aus !");
				System.out.println(x.getMessage());
			}
			
		}

	}

}