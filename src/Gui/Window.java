package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Balls.Ball;
import Balls.Control;

public class Window {
	

	private JFrame _frame;										//erstellen des Fenster
	private JPanel _haupt;										//erstellen des Panels im Fenster
	private JPanel _balls;
	
	private static Dimension _size = new Dimension(1224,500);	//Größe des Fensters
	
	Control control = new Control();
	Objects objects = new Objects(control);							//erstellen des Objekts objects welche alle Buttons enthält
	
		
	public void init(String name){
		
		_frame = new JFrame(name);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		_haupt = new JPanel(){
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics g){
				
				super.paintComponent(g);
				g.setColor(new Color (50, 116, 31));
				g.fill3DRect(12, 40, _size.width - 430, this.getWidth() - 90, true);
				g.fill3DRect(_size.width - 400, 40, 380, _size.height - 90, true);
					
			} 

			
		};
		
		_balls = new JPanel(){
			private static final long serialVersionUID = 1L;
			

			
			public void paintComponent(Graphics g){
				
				super.paintComponent(g);
				control.calc();
				control.draw(g);
				
				
					
			} 
			
			
		};
		
		
		_haupt.setMinimumSize(_size);
		_haupt.setPreferredSize(_size);
		_haupt.setMaximumSize(_size);
		_haupt.setBackground(Color.DARK_GRAY);
		_haupt.setVisible(true);
		_haupt.setLayout(null);
		
		_balls.setBounds(12,40,782,410);
		_balls.setVisible(true);
		_balls.setLayout(null);
	
		
		objects.init();
		objects.showHaupt(_haupt);
		
		_frame.setSize(_size);
		_frame.setResizable(false); 
		_frame.add(_haupt);
		_frame.add(_balls);
		_frame.setVisible(true);
		
	}

	
	public void FrameRender(){
		_balls.repaint();
	}
	
	
}