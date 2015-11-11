package Gui;

import java.awt.Graphics;

import Balls.Ball;


public class Main {

	public static void main(String[] args) {
		
		
		Window window = new Window();
		window.init("Billard");
		
		long nsTimerNow;
		long nsTimerLast = System.nanoTime();
		double deltaTime = 0.0d;
		double nsPerSecond = 1000000000.0d / 60.0d;
		boolean shouldRender = false;

		while (true) {	//rendern mit 60fps
			nsTimerNow = System.nanoTime();
			deltaTime += (nsTimerNow - nsTimerLast) / nsPerSecond;

			while (deltaTime >= 1.0d) {
				shouldRender = true;
				deltaTime -= 1.0d;
			}

			if (shouldRender) {
				window.FrameRender();
				shouldRender = false;
			}

			nsTimerLast = nsTimerNow;
			
		}
	}
}
