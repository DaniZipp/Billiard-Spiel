package Balls;

import java.awt.Graphics;
import java.awt.Color;

public class Ball{

	private static int radius = 10;
	private static int posX;
	private static int posY;
	private static int movX;
	private static int movY;
	private static int minX = 12;
	private static int maxX = 794;
	private static int minY = 40;
	private static int maxY = 410;
	
	public Ball(int x,int y) {
		this.posX = x;
		this.posY = y;


	}

	public static void render(Graphics g) {
		
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
