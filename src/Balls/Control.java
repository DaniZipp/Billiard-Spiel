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
		balls[0] = new Ball(100,190,15,0,10,1);
		balls[1] = new Ball(400,200,0,0,10,1);
		balls[2] = new Ball(400,180,0,0,10,1);
		balls[3] = new Ball(379,190,0,0,10,1);
		balls[4] = new Ball(421,190,0,0,10,1);
		balls[5] = new Ball(421,210,0,0,10,1);
		balls[6] = new Ball(421,170,0,0,10,1);
		balls[7] = new Ball(443,200,0,0,10,1);
		balls[8] = new Ball(443,180,0,0,10,1);
		balls[9] = new Ball(443,160,0,0,10,1);
		balls[10] = new Ball(443,220,0,0,10,1);
	}
	
	public void calc(float kraft,float winkel){
		for(int i = 0;i < balls.length;i++){			// berechnen der neuen Position
				balls[i].render();
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
