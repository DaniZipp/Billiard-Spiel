package Balls;

import java.awt.Color;
import java.awt.Graphics;

public class Control {

	int i;								//Variabeln für Schleifen etc.
	int b;
	int collBall;
	int d;
	 
	Ball[] balls = new Ball[2];
	
	public void create(){
		balls[0] = new Ball(100,100,1,0,1);
		balls[1] = new Ball(300,110,0,0,0);
	}
	
	public void calc(){
		for(i = 0;i < balls.length;i++){				// berechnen der neuen Position
			balls[i].render(i);
		}														
		if(d == 0){										//abfrage ob letztes frame gerendert wurde(um im nächsten frame keine Kollisionsabfrage durchzuführen)
			for(i = 0;i < balls.length;i++){			//für jeden ball
				for(b = i +1; b < balls.length;b++){	// für jeden ball außer sich selbst un den schon verglichenen
					if (balls[i].isCollision(balls[b])){	//kollisionsabfrage mit rückgabewert true oder false
						balls[i].collision(balls[b]);	//ausrtung der kollisionsdaten
						d++;							//d auf 1 setzen um im nächsten Frame die Kollisionsabfrage zu überspringen
					}
				}	
			}	
		}else{											//falls letzes frame kollidiert wurde
			d = 0;										//nächstes Frame wieder Kollisionsabfrage
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);						//zeichnen der Bälle
		balls[0].draw(g);
		g.setColor(Color.green);
		balls[1].draw(g);
	}
	
}
