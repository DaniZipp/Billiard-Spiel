package Balls;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;



public class Control {
	
	
	private Ball[] balls;
	
	public Control(){
		balls = new Ball[11];
		create();
	}
	
	public void create(){
		balls[0] = new Ball(100,190,0,0,10);
		balls[1] = new Ball(400,200,0,0,10);
		balls[2] = new Ball(400,180,0,0,10);
		balls[3] = new Ball(382,190,0,0,10);
		balls[4] = new Ball(420,190,0,0,10);
		balls[5] = new Ball(420,210,0,0,10);
		balls[6] = new Ball(420,170,0,0,10);
		balls[7] = new Ball(440,200,0,0,10);
		balls[8] = new Ball(440,180,0,0,10);
		balls[9] = new Ball(440,160,0,0,10);
		balls[10] = new Ball(440,220,0,0,10);
	}
	
	public void calc(){
		for(int i = 0;i < balls.length;i++){				// berechnen der neuen Position
			balls[i].render(i);
		}																		
			for(int i = 0;i < balls.length;i++){
				for(int j = i +1; j < balls.length;j++){
					if(balls[i] != balls[j]){
						if (balls[i].isCollision(balls[j])){	
							balls[i].collision(balls[j]);		
						}
					}
				}	
			}	
	}
	
	public void setZurücksetzten() {
		for (Ball ball : balls) {
			ball.resetBall();
		}
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);							//zeichnen der Bälle
		balls[0].draw(g);
		g.setColor(Color.red);
		balls[1].draw(g);
		balls[2].draw(g);
		balls[3].draw(g);
		balls[4].draw(g);
		balls[5].draw(g);
		balls[6].draw(g);
		balls[7].draw(g);
		balls[8].draw(g);
		balls[9].draw(g);
		balls[10].draw(g);
	}
	
}
