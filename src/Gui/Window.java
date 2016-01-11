package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Balls.Control;
import Physic.Physic;

public class Window {
	
	
	private JFrame _frame;											//erstellen des Fenster
	private JPanel _haupt;											//erstellen des Panels im Fenster
	private JPanel _balls;
	
	private static Dimension _size = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,600);		//Größe des Fensters
	
	Control control = new Control();
	Objects objects = new Objects(control);							//erstellen des Objekts objects welche alle Buttons enthält
	Physic physic = new Physic();
	
		
	public void init(String name){
		
		_frame = new JFrame(name);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		_haupt = new JPanel(){
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics g){
				
				super.paintComponent(g);
				g.setColor(new Color (50, 116, 31));
				g.fill3DRect(_size.width - 400, 40, 380, _size.height - 90, true);
				g.setColor(Color.BLACK);


			}
		};
		
		_balls = new JPanel(){
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics g){
				
				super.paintComponent(g);
				/*int y = 0;
				for(int i = 0;i < 3;i++){
					g.fillOval(387*i, y,20,20 );
				}
				y = 390;
				for(int b= 0;b < 3;b++){
					g.fillOval(387*b, y,20,20 );
				}*/
				if(control.getMovement() == 0){
					if(objects.getKraft() > 0){
						control.start(objects.getKraft(),objects.getWinkel());
					}
				}
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
		
		_balls.setBounds(45,70,794,410);
		_balls.setBackground(new Color (50, 116, 31));
		_balls.setVisible(true);
		_balls.setLayout(null);
	
		
		objects.init();
		objects.showFields(_haupt);
		
		
		
		_frame.setSize(_size);
		_frame.setResizable(false); 
		_frame.add(_balls);
		_frame.add(_haupt);
		_frame.setVisible(true);
		
	}

	
	public void FrameRender(){
		_balls.repaint();
	}
	
	
}