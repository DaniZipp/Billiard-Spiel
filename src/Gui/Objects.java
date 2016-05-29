package Gui;

import java.awt.Color;
import java.awt.Toolkit;
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
	private JButton stoﬂ_button;
	private JTextField winkel_textfield;
	private JTextField power_textfield;
	private JLabel		power_text;
	private JLabel		winkel_text;
	private JLabel		output_text;
	private float kraft;
	private float winkel;
	private JLabel physicsWidth_text;
	private JLabel physicsHeith_text;
	private boolean neuerStoﬂ;
	private boolean stoﬂEingabe;
	
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
	
	public boolean getStoﬂ(){
		return neuerStoﬂ;
	}
	
	public boolean getStoﬂEingabe(){
		return stoﬂEingabe;
	}
	
	public void setStoﬂ(boolean stoﬂ){
		this.neuerStoﬂ = stoﬂ;
	}
	
	public void setStoﬂEingabe(boolean stoﬂ){
		this.stoﬂEingabe = stoﬂ;
	}
	
	public void init()  {
	
	restart_button = new JButton("Neustart");
	restart_button.setBackground(new Color (50, 116, 31));
	restart_button.setBounds(12, 5, 100, 20);
	
	physic_button = new JButton("Physik");
	physic_button.setBackground(new Color (50, 116, 31));
	physic_button.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 400, 5, 80, 20);
	
	input_button = new JButton("Eingabe");
	input_button.setBackground(new Color (50, 116, 31));
	input_button.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 300, 5, 80, 20);
	
	stoﬂ_button = new JButton("neuer Stoﬂ");
	stoﬂ_button.setBackground(new Color (50, 116, 31));
	stoﬂ_button.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 5, 100, 20);
	
	restart_button.addActionListener(this);
	physic_button.addActionListener(this);
	input_button.addActionListener(this);
	stoﬂ_button.addActionListener(this);
	
	winkel_textfield  = new JTextField();
	winkel_textfield.setBackground(Color.WHITE);
	winkel_textfield.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 375, 180, 150, 30);
	
	power_textfield = new JTextField();
	power_textfield.setBackground(Color.WHITE);
	power_textfield.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 375, 95, 150, 30);
		
	power_text = new JLabel("Geschwindigkeit in m/s");
	power_text.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 375, 140, 150, 40);
	
	output_text = new JLabel("");
	output_text.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 375, 230, 400, 40);
	
	winkel_text = new JLabel("Winkel in ∞");
	winkel_text.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 375, 55, 150, 40);
	
	physicsWidth_text = new JLabel("Breite: 2,5m");
	physicsWidth_text.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 150,50,150,40);
	
	physicsHeith_text = new JLabel("Hˆhe: 1,25m");
	physicsHeith_text.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 150,70,150,40);
	
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
		panel.add(physicsHeith_text);
		panel.add(physicsWidth_text);
		panel.add(stoﬂ_button);
		
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == restart_button) {
			control.setZur¸cksetzten();
		}
		if(e.getSource() == physic_button) {
			//noch zu erledigen
		}
		if(e.getSource() == input_button) {
			if(neuerStoﬂ == true){
				try{
					stoﬂEingabe = true;
					output_text.setText("");
					kraft = (Integer.parseInt(winkel_textfield.getText()));
					winkel = (Integer.parseInt(power_textfield.getText()));
				}catch(Exception x){
					output_text.setText("Geben Sie eine Zahl ein oder f¸llen Sie bitte beider Felder aus !");
					System.out.println(x.getMessage());
				}
			}
			
		}
		if(e.getSource() == stoﬂ_button){
			neuerStoﬂ = true;
		}

	}

}