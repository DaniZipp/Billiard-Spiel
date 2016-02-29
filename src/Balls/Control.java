package Balls;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;



public class Control {
	
	
	private Ball[] balls;
	private float movement;
	
	public Control(){
		balls = new Ball[12];
		create();
	}
	public float getMovement(){
		return movement;
	}
	
	public void create(){
		balls[0] = new Ball(100,190,0,0,8.72f,0.17f);
		balls[1] = new Ball(380,190,0,0,8.72f,0.17f);
		balls[2] = new Ball(380+9*2,190+9,0,0,8.72f,0.17f);
		balls[3] = new Ball(380+9*2,190-9,0,0,8.72f,0.17f);
		balls[4] = new Ball(380+9*4,190,0,0,8.72f,0.17f);
		balls[5] = new Ball(380+9*4,190+9*2,0,0,8.72f,0.17f);
		balls[6] = new Ball(380+9*4,190-9*2,0,0,8.72f,0.17f);
		balls[7] = new Ball(380+9*6,190+9,0,0,8.72f,0.17f);
		balls[8] = new Ball(380+9*6,190-9,0,0,8.72f,0.17f);
		balls[9] = new Ball(380+9*6,190+9*2,0,0,8.72f,0.17f);
		balls[10] = new Ball(380+9*6,190-9*2,0,0,8.72f,0.17f);
		balls[11] = new Ball(0,0,0,0,8.72f,0.17f);
	}
	
	public void stoﬂ(float kraft,float winkel){
		if(winkel <= 90 ||winkel >= 270){
			balls[11].setPosX(balls[0].getPosX() - (float)Math.sin(balls[0].getRadius()*2));
		}else{
			balls[11].setPosX(balls[0].getPosX() + (float)Math.sin(balls[0].getRadius()*2));
		}
		if(winkel <= 180){
			balls[11].setPosY(balls[0].getPosY() - (float)Math.cos(balls[0].getRadius()*2));
		}else{
			balls[11].setPosY(balls[0].getPosY() + (float)Math.cos(balls[0].getRadius()*2));
		}
		balls[11].setMovX(kraft);
		

	}
	
	public void calc(){
		movement = 0;
		for(int i = 0;i < balls.length;i++){			// berechnen der neuen Position
				balls[i].render();
				movement += balls[i].getMovX() + balls[i].getMovY();
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
	
	public void setZur¸cksetzten() {
		for (Ball ball : balls) {
			ball.resetBall();
		}
		
	}
	
	public void stop(){
		for (Ball ball : balls) {
			ball.setMovX(0);
			ball.setMovY(0);
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);							//zeichnen der B‰lle
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
