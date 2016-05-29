package Balls;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;



public class Control {
	
	
	private Ball[] balls;
	private Hole[] holes;
	private float movement;
	private Queue queue;
	private float winkelC;
	private float kraftC;
	private boolean q = false;
	
	public Control(){
		balls = new Ball[11];
		holes = new Hole[6];
		create();
	}
	public float getMovement(){
		return movement;
	}
	
	public void create(){
		balls[0] = new Ball(110,200,0,0,8.72f,0.17f);
		balls[1] = new Ball(490,200,0,0,8.72f,0.17f);
		balls[2] = new Ball(490+9*2,200+9,0,0,8.72f,0.17f);
		balls[3] = new Ball(490+9*2,200-9,0,0,8.72f,0.17f);
		balls[4] = new Ball(490+9*4,200,0,0,8.72f,0.17f);
		balls[5] = new Ball(490+9*4,200+9*2,0,0,8.72f,0.17f);
		balls[6] = new Ball(490+9*4,200-9*2,0,0,8.72f,0.17f);
		balls[7] = new Ball(490+9*6,200+9,0,0,8.72f,0.17f);
		balls[8] = new Ball(490+9*6,200-9,0,0,8.72f,0.17f);
		balls[9] = new Ball(490+9*6,200+9*2,0,0,8.72f,0.17f);
		balls[10] = new Ball(490+9*6,200-9*2,0,0,8.72f,0.17f);
		queue = new Queue(70,0.2f);
		holes[0] = new Hole(12,12,10);
		holes[1] = new Hole(802,12,10);
		holes[2] = new Hole(407,10,10);
		holes[3] = new Hole(12,418,10);
		holes[4] = new Hole(802,418,10);
		holes[5] = new Hole(407,420,10);
	}
	
	public void stoﬂ(float kraft,float winkel){

		
		winkel = (float)Math.toRadians(winkel);
		
		winkelC = winkel;
		kraftC = kraft;
		
		queue.setX2(balls[0].getPosX() - (float)Math.cos(winkel)*balls[0].getRadius());
		queue.setX1(queue.getX2()-(float)Math.cos(winkel)*queue.getLenght());
		queue.setMovX(Math.cos(winkel)*queue.getSpeed() * -1);
		
		
		queue.setY2(balls[0].getPosY() + (float)Math.sin(winkel)*balls[0].getRadius());
		queue.setY1(queue.getY2()+(float)Math.sin(winkel)*queue.getLenght());
		queue.setMovY((float)Math.sin(winkel)*queue.getSpeed());
		q = true;
		

	}
	
	
	
	public void calc(){
		movement = 0;
		
		queue.render();
		
		if(q == true){
			if(queue.back(balls[0])){
				queue.setMovX((float)(Math.cos(winkelC)*kraftC));
				queue.setMovY((float)(Math.sin(winkelC)*kraftC) * -1);
			}
		}
		

		
		if(balls[0].isQueueCollision( queue.getX2(),queue.getY2())){
			balls[0].setMovX((float)(Math.cos(winkelC)*kraftC));
			balls[0].setMovY((float)(Math.sin(winkelC)*kraftC) * -1);
			queue.setMovX(0);
			queue.setMovY(0);
			queue.reset();
			q = false;
		}
		
		for(int i = 0;i < holes.length;i++){
			for(int b = 0;b < balls.length;b++){
				if(holes[i].isIn(balls[b])){
					balls[b].setMovX(0);
					balls[b].setMovY(0);
					balls[b].setPosX(-10);
					balls[b].setPosY(-10);
				}
			}
		}
		
		for(int i = 0;i < balls.length;i++){			// berechnen der neuen Position

			balls[i].render();
			if(balls[i].tooSlow()){
				balls[i].setMovX(0);
				balls[i].setMovY(0);
			}
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
		holes[0].draw(g);
		holes[1].draw(g);
		holes[2].draw(g);
		holes[3].draw(g);
		holes[4].draw(g);
		holes[5].draw(g);
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
