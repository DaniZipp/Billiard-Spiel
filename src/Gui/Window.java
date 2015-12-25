package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Balls.Ball;

public class Window {
	

	private JFrame _frame;										//erstellen des Fenster
	private JPanel _haupt;										//erstellen des Panels im Fenster
	
	private static Dimension _size = new Dimension(1224, 500);	//Größe des Fensters
	
	Objects objects = new Objects();	//erstellen des Objekts objects welche alle Buttons enthält
	
	int i;								//Variabeln für Schleifen etc.
	int b;
	int amountBalls = 2;
	int collBall;
	int d;
	 
	Ball[] balls = new Ball[amountBalls];	//erstellen eines Arrays um mehrere Kugeln zu generieren
		
	public void init(String name){
		
		_frame = new JFrame(name);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

			
		balls[0] = new Ball(100,95,1,0,100,0);	//erstellen der Kugeln
		balls[1] = new Ball(400,100,0,0,0,0);
		

		_haupt = new JPanel(){
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics g){
				
				super.paintComponent(g);
				g.setColor(new Color (50, 116, 31));
				g.fill3DRect(12, 40, _size.width - 430, this.getWidth() - 90, true);
				g.fill3DRect(_size.width - 400, 40, 380, _size.height - 90, true);
			
				for(i = 0;i < balls.length;i++){				// berechnen der neuen Position
					balls[i].render(i);
				}														
				if(d == 0){										//abfrage ob letztes frame gerendert wurde(um im nächsten frame keine Kollisionsabfrage durchzuführen)
					for(i = 0;i < balls.length;i++){			//für jeden ball
						for(b = i +1; b < balls.length;b++){	// für jeden ball außer sich selbst un den schon verglichenen
							if (balls[i].vectors(balls[b])){	//kollisionsabfrage mit rückgabewert true oder false
								balls[i].collision(balls[b]);	//ausrtung der kollisionsdaten
								d++;							//d auf 1 setzen um im nächsten Frame die Kollisionsabfrage zu überspringen
							}
						}	
					}	
				}else{											//falls letzes frame kollidiert wurde
					d = 0;										//nächstes Frame wieder Kollisionsabfrage
				}
				g.setColor(Color.white);						//zeichnen der Bälle
				balls[0].draw(g);
				g.setColor(Color.green);
				balls[1].draw(g);

				
				
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