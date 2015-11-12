package Balls;

import java.awt.Graphics;
import java.awt.Color;

public class Ball{

	private int radius = 10;
	private int posX;
	private int posY;
	private int movX;
	private int movY;
	private int minX = 12;
	private int maxX = 794 - 2*radius;
	private int minY = 40;
	private int maxY = 450  - 2*radius;
	
	public Ball(int x,int y,int mx,int my) {
		this.posX = x;
		this.posY = y;
		this.movX = mx;
		this.movY = my;


	}
	
	public void getPos(){
		System.out.println("X:" + posX + "Y:" + posY);
	}

	public void render(Graphics g) {
		
		posX = posX + movX;
		posY = posY + movY;
		if(posX <= minX  ){
			movX = -movX;
			System.out.println("minX");
		}
		if(posX >= maxX ){
			movX = -movX;
			System.out.println("maxX");
		}
		if(posY <= minY){
			movY = -movY;
			System.out.println("minY");
		}
		if(posY >= maxY){
			movY = -movY;
			System.out.println("maxY"
					+ "");
		}
		g.setColor(Color.black);
		g.fillOval(posX, posY, radius * 2, radius * 2);
	}

}
