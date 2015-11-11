package Balls;

import java.awt.Graphics;
import java.awt.Color;

public class Ball{

	private int radius = 10;
	private int posX;
	private int posY;
	private int movX;
	private int movY;
	private int minX = 70 - 2*radius;
	private int maxX = 410;
	private int minY = 794 - 2*radius;
	private int maxY = 12;
	
	public Ball(int x,int y,int mx,int my) {
		this.posX = x;
		this.posY = y;
		this.movX = mx;
		this.movY = my;


	}

	public void render(Graphics g) {
		
		posX = posX + movX;
		posY = posY + movY;
		if(posX == minX | posX == maxX){
			movY = -movY;
		}
		if(posY == minY | posY == maxY){
			movX = -movX;
		}
		g.setColor(Color.WHITE);
		g.fillOval(posX, posY, radius * 2, radius * 2);
	}

}
