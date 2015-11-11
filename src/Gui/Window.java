package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Balls.Ball;


public class Window {
	
	
	Objects objects = new Objects();
	Ball ball = new Ball(200,200,3,3);

	private JFrame _frame;	//erstellen des Fenster
	private JPanel _haupt;	//erstellen des Hauptfensters
	
	private static Dimension _size = new Dimension(1224, 500);
	
	public void init(String name){
		_frame = new JFrame(name);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		_haupt = new JPanel(){
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics g){
				
				super.paintComponent(g);
				g.setColor(new Color (50, 116, 31));
				g.fill3DRect(12, 40, _size.width - 430, _size.height - 90, true);
				g.fill3DRect(_size.width - 400, 40, 380, _size.height - 90, true);
				ball.render(g);
				
			} 

			
			
		};
		
		
		_haupt.setMinimumSize(_size);
		_haupt.setPreferredSize(_size);
		_haupt.setMaximumSize(_size);
		_haupt.setBackground(Color.DARK_GRAY);
		_haupt.setVisible(true);
		_haupt.setLayout(null);
		
		objects.init();
		objects.showHaupt(_haupt);
		
		_frame.setSize(_size);
		_frame.setResizable(false); 
		_frame.add(_haupt);
		_frame.setVisible(true);
		
	}

	
	public void FrameRender(){
		_frame.repaint();
	}
	
	
}