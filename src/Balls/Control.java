package Balls;

import java.awt.Color;
import java.awt.Graphics;

public class Control {
								
	private Ball[] balls;
	public Control(){
		balls = new Ball[3];
		create();
	}
	
	public void create(){
		balls[0] = new Ball(100,100,1,0,10);
		balls[1] = new Ball(300,110,0,0,10);
		balls[2] = new Ball(400,200,0,0,10);
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
	}
	
}
