package Balls;

import java.awt.Graphics;

public class Ball{
	
	//Attribute
	private float  radius;
	private float startX;
	private float startY;
	private float  posX;
	private float  posY;
	private float  movX;
	private float  movY;
	private float  minX = 0 + radius;
	private float  maxX = 782 - radius;
	private float minY = 0 + radius;
	private float maxY = 410 - radius;
	private float dX;
	private float dY;
	private float mass = 1;
	
	//Konstruktor
	public Ball(float x,float y,float mx,float my,float radius) {
		this.posX = x;
		this.posY = y;
		this.startX = x;
		this.startY = y;
		this.movX = mx;
		this.movY = my;
		this.radius = radius;

	}
	
	
	//get und set Methoden
	public float getPosX(){
		return posX;
	}
	
	public float getPosY(){
		return posY;
	}	
	public float getMovX(){
		return movX;
	}
	
	public float getMovY(){
		return movY;
	}
		
	public float getRadius(){
		return radius;
	}
	
	
	public void setMovX(float movX){
		this.movX = movX;
	}
	
	public void setMovY(float movY){
		this.movY = movY;
	}
	

	// Übergabeparameter i wird nicht verwendet
	public void render(int i) {		//berechnung der neuen X- und Y-Werte und Bandenkollisionsabfrage
		
		movX *= 0.999f;
		movY *= 0.999f;
		
		posX = posX + movX;
		posY = posY + movY;
		
		if(posX - radius <= minX  ){
			movX = -movX;
		}
		if(posX + radius >= maxX ){
			movX = -movX;
		}
		if(posY - radius <= minY){
			movY = -movY;
		}
		if(posY + radius >= maxY){
			movY = -movY;
		}
	}
	/**
	 * detects collsion with another ball
	 * @param ob the other ball
	 * @return if a collision has happened
	 */
	public boolean isCollision(Ball ob){	//Kollisionsabfrage
		dX = posX - ob.getPosX();		
		dY = posY - ob.getPosY();
		float vector = dX * dX + dY * dY;
		float hypo = radius * radius * 4;
		if(hypo >= vector){
			return true;
		}else{
			return false;
		}
	}

	public void collision(Ball ob){ 	//Berechnung der Kollision
		

		


		
	}
	public void draw(Graphics g){	//zeichnen einer Kugel
		g.fillOval((int)(posX - radius), (int)(posY - radius), (int)radius * 2, (int)radius * 2);
	}
	
	public void resetBall(){
		posX = startX;
		posY = startY;
	}




}
