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
	private float minX = 0 + radius;
	private float maxX = 794 - radius;
	private float minY = 0 + radius;
	private float maxY = 410 - radius;
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

	public void render() { 	// berechnung der neuen X- und Y-Werte und
							// Bandenkollisionsabfrage

		if (movX != 0 || movY != 0) {

			float friction = mass * 9.81f * (0.000007f/0.0572f); 			//Rollreibung = natürliche Kraft * Rollreibungskoeffizient (Fn = Fg)
			float slow = friction / mass;									//F = m * a -> a = F/m
			float mX = movX;
			float mY = movY;
			
			
			if(movX < 0){
				mX *= -1;
			}
			if(movY < 0){
				mY *= -1;
			}
			
			float vX = mX / 794 * 2.5f;
			float vY = mY / 410 * 1.25f;

			float t = 1.0f / 60;
			float vSlow = slow * t;

			float sX = 0;
			float sY = 0;
			
			if(movX != 0){
				sX = vSlow / vX;
			}
			if(movY != 0){
				sY = vSlow / vY;
			}
			
			
			sX = 1 - sX;
			sY = 1 - sY;

			
			System.out.println(vX);
			System.out.println(slow);
			System.out.println(t);
			System.out.println(vSlow);
			System.out.println(sX);


			movX = movX * sX;
			movY = movY * sY;

			

		}
		
		posX = posX + movX;
		posY = posY + movY;

		if (posX - radius <= minX) { //Reflexion
			movX = -movX;
		}
		if (posX + radius >= maxX) {
			movX = -movX;
		}
		if (posY - radius <= minY) {
			movY = -movY;
		}
		if (posY + radius >= maxY) {
			movY = -movY;
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
