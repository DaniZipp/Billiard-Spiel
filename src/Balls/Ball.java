package Balls;

import java.awt.Graphics;

public class Ball {

	// Attribute
	private float radius;
	private float startX;
	private float startY;
	private float posX;
	private float posY;
	private float movX;
	private float movY;
	private float minX = 10 + radius;
	private float maxX = 804 - radius;
	private float minY = 10 + radius;
	private float maxY = 420 - radius;
	private float dX;
	private float dY;
	private float mass;
	private float Epsilon = 1f;

	// Konstruktor
	public Ball(float x, float y, float mx, float my, float radius, float mass) {
		this.posX = x;
		this.posY = y;
		this.startX = x;
		this.startY = y;
		this.movX = mx;
		this.movY = my;
		this.radius = radius;
		this.mass = mass;

	}

	// get und set Methoden
	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}

	public float getMovX() {
		return movX;
	}

	public float getMovY() {
		return movY;
	}

	public float getRadius() {
		return radius;
	}

	public float getMass() {
		return mass;
	}

	public void setMovX(float movX) {
		this.movX = movX;
	}

	public void setMovY(float movY) {
		this.movY = movY;
	}

	public void setPosX(float x) {
		this.posX = x;
	}

	public void setPosY(float y) {
		this.posY = y;
	}
	

	public void render() { 											// berechnung der neuen X- und Y-Werte und Bandenkollisionsabfrage
		

		/*float friction = mass * 9.81f * (0.000007f / 0.0572f);	 	// Rollreibung = nat�rliche Kraft * Rollreibungskoeffizient (Fn = Fg)
		float slow = friction / mass; 								// F = m * a -> a = F/m
		float mX = movX;
		float mY = movY;

		if (movX < 0) { 				//fallsGeschwindigkeit negativ zu positiv konvertieren
			mX *= -1;
		}
		if (movY < 0) {
			mY *= -1;
		}

		float vX = mX / 794 * 2.5f; 	//alteGeschwindigkeitX
		float vY = mY / 410 * 1.25f;	//alte GeschwindigkeitY

		float t = 1.0f / 60; 			//Zeit:(1/60)Sekunde
		float vSlow = slow * t;			//Verlangsamung in einer 60stel Sekunde

		float sX = 0;
		float sY = 0;

		if (movX != 0) {
			sX = vSlow / vX;			//Verh�ltnis Verlangsamung zu Geschwindigkeit f�r X
		}
		if (movY != 0) {
			sY = vSlow / vY;			//Verh�ltnis Verlangsamung zu Geschwindigkeit f�r Y
		}

		sX = 1 - sX;					//Berechnung des Faktors f�r die neue Geschwindigkeit f�r X
		sY = 1 - sY;					//Berechnung des Faktors f�r die neue Geschwindigkeit f�r Y

		movX = movX * sX;				//Berechnung der neuen Geschwindigkeit f�r X
		movY = movY * sY;*/				//Berechnung der neuen Geschwindigkeit f�r Y
			
		movX = movX * 0.9965f;
		movY = movY * 0.9965f;
		
		posX = posX + movX;
		posY = posY + movY;

		if (posX - radius <= minX) { 	// Reflexion
			movX = -movX;
			movX = movX*0.9f;
			movY = movY*0.9f;
		}
		if (posX + radius >= maxX) {
			movX = -movX;
			movX = movX*0.9f;
			movY = movY*0.9f;
		}
		if (posY - radius <= minY) {
			movY = -movY;
			movX = movX*0.9f;
			movY = movY*0.9f;
		}
		if (posY + radius >= maxY) {
			movY = -movY;
			movX = movX*0.9f;
			movY = movY*0.9f;
		}
		
	}
	
	public boolean tooSlow(){
		
		float NmovX = movX;
		float NmovY = movY;
		
		if(NmovX < 0){
			NmovX = NmovX * -1;
		}
		if(NmovY < 0){
			NmovY = NmovY * -1;
		}
		
		
		float mov = NmovX+ NmovY;
		
		
				
		if(mov < 0.2f){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * detects collsion with another ball
	 * 
	 * @param ob
	 *            the other ball
	 * @return if a collision has happened
	 */
	public boolean isCollision(Ball ob) { // Kollisionsabfrage
		
		dX = posX - ob.getPosX();
		dY = posY - ob.getPosY();
		float vector = dX * dX + dY * dY;
		float hypo = radius * radius * 4;
		if (hypo >= vector) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isQueueCollision(float x,float y){
		
		float dqx = x - posX ;
		float dqy = y - posY ;
		float vector = dqx * dqx + dqy * dqy;
		float hypoq = radius * radius;
		
		if(vector <= hypoq){
			return true;
		}else{
			return false;
		}
			
	}

	public void collision(Ball ob) { // Berechnung der Kollision

		float normalX = posX - ob.getPosX();
		float normalY = posY - ob.getPosY();
		float length = (float) Math.sqrt(normalX * normalX + normalY * normalY);
		normalX /= length;
		normalY /= length;

		float overlapplength = radius + ob.getRadius() - length;
		float masses = mass + ob.getMass();

		ob.setPosX(ob.getPosX() + (-normalX * overlapplength) * mass / masses);
		ob.setPosY(ob.getPosY() + (-normalY * overlapplength) * mass / masses);
		posX += +normalX * overlapplength * ob.getMass() / masses;
		posY += +normalY * overlapplength * ob.getMass() / masses;

		float f = ((-(1 + Epsilon)) * ((movX - ob.getMovX()) * normalX + (movY - ob.getMovY()) * normalY))
				/ (1 / ob.getMass() + 1 / mass);

		float oldMovX = movX;
		float oldMovY = movY;
		float oldMovXOb = ob.getMovX();
		float oldMovYOb = ob.getMovY();

		ob.setMovX(oldMovXOb - f / ob.getMass() * normalX);
		ob.setMovY(oldMovYOb - f / ob.getMass() * normalY);

		movX = oldMovX + f / mass * normalX;
		movY = oldMovY + f / mass * normalY;
		
		movX = movX*0.999f;
		movY = movY*0.999f;
		
		ob.setMovX(ob.getMovX()*0.95f);
		ob.setMovY(ob.getMovY()*0.95f);

	}

	public void draw(Graphics g) { // zeichnen einer Kugel
		g.fillOval((int) (posX - radius), (int) (posY - radius), (int) radius * 2, (int) radius * 2);
	}

	public void resetBall() {
		posX = startX;
		posY = startY;
		movX = 0;
		movY = 0;
	}

}
