package com.main;

import java.awt.Color;
import java.awt.Graphics;


public class Ball {

	public static final int SIZE = 16;

	private int x, y; 
	private int xVel, yVel; // either 1 or -1
	private int speed = 5; // speed of the ball

	
	public Ball() {
		reset();
	}

	
	private void reset() {
		// initial position
		x = Game.WIDTH / 2 - SIZE / 2;
		y = Game.HEIGHT / 2 - SIZE / 2;

		// initial velocity
		xVel = Game.sign(Math.random() * 2.0 - 1);
		yVel = Game.sign(Math.random() * 2.0 - 1);
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, SIZE, SIZE);
	}

	
	public void update(Paddle lp, Paddle rp) {

		// update position
		x += xVel * speed;
		y += yVel * speed;

		// collisions

		// with ceiling and floor
		if (y + SIZE >= Game.HEIGHT || y <= 0)
			changeYDir();

		// with walls

		if (x + SIZE >= Game.WIDTH) { // right wall
			lp.addPoint();
			reset();
		}
		if (x <= 0) { // left wall
			rp.addPoint();
			reset();
		}
	}

	
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	
	public void changeXDir() {
		xVel *= -1;
	}

	
	public void changeYDir() {
		yVel *= -1;
	}

}
