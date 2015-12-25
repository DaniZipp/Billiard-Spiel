package Balls;

import java.awt.Graphics;

public class Ball{
	
	//Attribute
	private float  radius = 10;
	private float  posX;
	private float  posY;
	private float  movX;
	private float  movY;
	private float  minX = 12 + radius;
	private float  maxX = 794 - radius;
	private float minY = 40 + radius;
	private float maxY = 450 - radius;
	private double speed;
	private float dX;
	private float dY;
	private float mass;
	
	//Konstruktor
	public Ball(float x,float y,float mx,float my,float speed,float mass) {
		this.posX = x;
		this.posY = y;
		this.movX = mx;
		this.movY = my;
		this.speed = speed;
		this.mass = mass;


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
	
	public double getSpeed(){
		return speed;
	}
	
	public float getMass(){
		return mass;
	}
	
	public void setMovX(float movX){
		this.movX = movX;
	}
	
	public void setMovY(float movY){
		this.movY = movY;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}

	public void render(int i) {		//berechnung der neuen X- und Y-Werte und Bandenkollisionsabfrage
		
		posX = posX + movX * (float)(speed/100);
		posY = posY + movY * (float)(speed/100);
		
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
	public boolean vectors(Ball ob){	//Kollisionsabfrage
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
		

		
		//für kollision von links
		if(dX < 0){
			//für kollision von oben
			if(dY < 0){
				ob.setSpeed(speed * (Math.atan(Math.toDegrees(-dY/-dX))/90));
				speed = speed - ob.getSpeed();
				
				movX = -dX;
				movY = dY;
				ob.setMovX(-dX);
				ob.setMovY(-dY);
			}
			//für kollision von unten
			else{
				ob.setSpeed(speed * (Math.atan(Math.toDegrees(dY/-dX))/90));
				speed = speed - ob.getSpeed();
				
				movX = -dX;
				movY = -dY;
				ob.setMovX(-dX);
				ob.setMovY(-dY);
			}

			
		}
		//für kollision von rechts
		if(dX > 0){
			//für kollision von oben
			if(dY < 0){
				ob.setSpeed(speed * (Math.atan(Math.toDegrees(-dY/dX))/90));
				speed = speed - ob.getSpeed();
				
				movX = dX;
				movY = -dY;
				ob.setMovX(dX);
				ob.setMovY(dY);
			}
			//für kollision von unten
			else{
				ob.setSpeed(speed * (Math.atan(Math.toDegrees(dY/dX))/90));
				speed = speed - ob.getSpeed();
				
				movX = dX;
				movY = dY;
				ob.setMovX(dX);
				ob.setMovY(dY);
			}
		}
	
		
		//funktioniert nicht :( ideen sind aber am start

		
	}
	public void draw(Graphics g){	//zeichnen einer Kugel
		g.fillOval((int)(posX - radius), (int)(posY - radius), (int)radius * 2, (int)radius * 2);
	}




}
