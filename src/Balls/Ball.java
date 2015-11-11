package Balls;

import java.awt.Graphics;
import java.awt.Color;

public class Ball{

	private int radius = 10;
	private double posX;
	private double posY;
	private double movX;
	private double movY;
	private int minX = 225;//190 // der wert muss bleiben
	private int maxX = 35 - 2*radius;//630 // dieser ändert nichts
	private int minY = 0; // wert passt
	private int maxY = 270  - 2*radius;// wert passt
	
	public Ball(double x,double y,double mx,double my) {
		this.posX = x;
		this.posY = y;
		this.movX = mx;
		this.movY = my;


	}

	public void render(Graphics g) {
		
		posX = posX + movX;
		posY = posY + movY;
		if(posX == minX  ){
			movY = -movY;
		}
		if(posX == maxX ){
			movY = -movY;
		}
		if(posY == minY){
			movX = -movX;
		}
		if(posY == maxY){
			movX = -movX;
		}
		g.setColor(Color.black);
		g.fillOval((int)posX, (int)posY, radius * 2, radius * 2);
	}

}
