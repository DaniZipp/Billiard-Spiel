package Balls;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;



public class Control {
	
	
	private Ball[] balls;
	private float movement;
	private Queue queue;
	private float winkelC;
	private float kraftC;
	
	public Control(){
		balls = new Ball[11];
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
		queue = new Queue(70,0.2f);
	}
	
	public void stoﬂ(float kraft,float winkel){
		/*if(winkel <= 90 ||winkel >= 270){
			queue.setX2(balls[0].getPosX() - (float)Math.cos(winkel)*balls[0].getRadius());
			queue.setX1(queue.getX2()-(float)Math.cos(winkel)*queue.getLenght());
			queue.setMovX((float)Math.cos(winkel)*queue.getSpeed());
			balls[0].setMovX((float)Math.cos(winkel)*kraft);
		}else{
			queue.setX2(balls[0].getPosX() + (float)Math.cos(winkel)*balls[0].getRadius());
			queue.setX1(queue.getX2()+(float)Math.cos(winkel)*queue.getLenght());
			queue.setMovX((float)Math.cos(winkel)*queue.getSpeed() * -1);
			balls[0].setMovX((float)Math.cos(winkel)*kraft * -1);
		}
		if(winkel <= 180){
			queue.setY2(balls[0].getPosY() + (float)Math.sin(winkel)*balls[0].getRadius());
			queue.setY1(queue.getY2()+(float)Math.sin(winkel)*queue.getLenght());
			queue.setMovY((float)Math.sin(winkel)*queue.getSpeed() * -1);
			balls[0].setMovY((float)Math.sin(winkel)*kraft * -1);
		}else{
			queue.setY2(balls[0].getPosY() - (float)Math.sin(winkel)*balls[0].getRadius());
			queue.setY1(queue.getY2()-(float)Math.sin(winkel)*queue.getLenght());
			queue.setMovY((float)Math.sin(winkel)*queue.getSpeed());
			balls[0].setMovY((float)Math.sin(winkel)*kraft);
		}*/
		
		winkel = (float)Math.toRadians(winkel);
		
		winkelC = winkel;
		kraftC = kraft;
		
		queue.setX2(balls[0].getPosX() - (float)Math.cos(winkel)*balls[0].getRadius());
		queue.setX1(queue.getX2()-(float)Math.cos(winkel)*queue.getLenght());
		queue.setMovX(Math.cos(winkel)*queue.getSpeed() * -1);
		
		
		queue.setY2(balls[0].getPosY() + (float)Math.sin(winkel)*balls[0].getRadius());
		queue.setY1(queue.getY2()+(float)Math.sin(winkel)*queue.getLenght());
		queue.setMovY((float)Math.sin(winkel)*queue.getSpeed());

	}
	
	
	
	public void calc(){
		movement = 0;
		
		queue.render();
		
		if(queue.back(balls[0])){
			queue.setMovX(queue.getMovX() * -1);
			queue.setMovY(queue.getMovY() * -1);
		}
		

		
		if(balls[0].isQueueCollision( queue.getX2(),queue.getY2())){
			balls[0].setMovX((float)(Math.cos(winkelC)*kraftC));
			balls[0].setMovY((float)(Math.sin(winkelC)*kraftC) * -1);
			queue.setMovX(0);
			queue.setMovY(0);
		}
		
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
		g.setColor(new Color (94,74,0));
		queue.draw(g);
	}
	
}
