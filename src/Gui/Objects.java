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
	
	private JButton restart_button;
	private JButton physic_button;
	private JButton input_button;
	private JTextField winkel_textfield;
	private JTextField power_textfield;
	private JLabel		power_text;
	private JLabel		winkel_text;
	private JLabel		output_text;
	private float kraft;
	private float winkel;
	
	private Control control = null;
	
	public Objects(Control control){
		this.control = control;
	}
	
	public float getKraft(){
		return kraft;
	}
	
	public float getWinkel(){
		return winkel;
	}
	
	public void init()  {
	
	restart_button = new JButton("Neustart");
	restart_button.setBackground(new Color (50, 116, 31));
	restart_button.setBounds(12, 5, 100, 20);
	
	physic_button = new JButton("Physik");
	physic_button.setBackground(new Color (50, 116, 31));
	physic_button.setBounds(824, 5, 80, 20);
	
	input_button = new JButton("Eingabe");
	input_button.setBackground(new Color (50, 116, 31));
	input_button.setBounds(940, 5, 80, 20);
	
	
	restart_button.addActionListener(this);
	physic_button.addActionListener(this);
	input_button.addActionListener(this);
	
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
		panel.add(restart_button);
		panel.add(physic_button);
		panel.add(input_button);
		panel.add(winkel_textfield);
		panel.add(power_textfield);
		panel.add(power_text);
		panel.add(winkel_text);
		panel.add(output_text);
		
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == restart_button) {
			control.setZurücksetzten();
		}
		if(e.getSource() == physic_button) {
			//noch zu erledigen
		}
		if(e.getSource() == input_button) {
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