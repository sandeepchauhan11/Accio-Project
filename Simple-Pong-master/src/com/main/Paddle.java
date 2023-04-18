package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Paddle {

	private int x, y; // positions
	private int vel = 0; // speed and direction of paddle
	private int speed = 10; // speed of the paddle movement
	private int width = 22, height = 85; // dimensions
	private int score = 0; // score for the player
	private Color color; // color of the paddle
	private boolean left; // true if it's the left paddle

	
	public Paddle(Color c, boolean left) {
		// initial properties
		color = c;
		this.left = left;

		if (left) // different x values if right or left paddle
			x = 0;
		else
			x = Game.WIDTH - width;

		y = Game.HEIGHT / 2 - height / 2;

	}

	/**
	 * add a point to the player
	 */
	public void addPoint() {
		score++;
	}

	public void draw(Graphics g) {

		// draw paddle
		g.setColor(color);
		g.fillRect(x, y, width, height);

		// draw score
		int sx; 
		int padding = 25; 
		String scoreText = Integer.toString(score);
		Font font = new Font("Roboto", Font.PLAIN, 50);

		if (left) {
			int strWidth = g.getFontMetrics(font).stringWidth(scoreText); // we need the width of the string so we can
																			// center it properly (for perfectionists)
			sx = Game.WIDTH / 2 - padding - strWidth;
		} else {
			sx = Game.WIDTH / 2 + padding;
		}

		g.setFont(font);
		g.drawString(scoreText, sx, 50);
	}

	public void update(Ball b) {

		// update position
		y = Game.ensureRange(y + vel, 0, Game.HEIGHT - height);

		// collisions
		int ballX = b.getX();
		int ballY = b.getY();

		if (left) {

			if (ballX <= width + x && ballY + Ball.SIZE >= y && ballY <= y + height)
				b.changeXDir();

		} else {

			if (ballX + Ball.SIZE >= x && ballY + Ball.SIZE >= y && ballY <= y + height)
				b.changeXDir();

		}

	}

	
	public void switchDirections(int direction) {
		vel = speed * direction;
	}

	/**
	 * stop moving the paddle
	 */
	public void stop() {
		vel = 0;
	}

}
