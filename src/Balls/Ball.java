package Balls;

import java.awt.Graphics;
import java.awt.Color;

public class Ball{

	private int radius = 10;
	private int posX;
	private int posY;
	private int movX;
	private int movY;
	private int minX = 190;
	private int maxX = 630 - 2*radius;
	private int minY = 70;
	private int maxY = 270  - 2*radius;
	
	public Ball(int x,int y,int mx,int my) {
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
		g.fillOval(posX, posY, radius * 2, radius * 2);
	}

}
