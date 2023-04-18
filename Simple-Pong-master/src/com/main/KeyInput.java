package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

	private Paddle lp; // left paddle
	private boolean lup = false; // lup = left up (up1 in video)
	private boolean ldown = false;

	private Paddle rp; // right paddle
	private boolean rup = false;
	private boolean rdown = false;

	
	public KeyInput(Paddle p1, Paddle p2) {

		lp = p1;
		rp = p2;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			rp.switchDirections(-1);
			rup = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			rp.switchDirections(1);
			rdown = true;
		}
		if (key == KeyEvent.VK_W) {
			lp.switchDirections(-1);
			lup = true;
		}
		if (key == KeyEvent.VK_S) {
			lp.switchDirections(1);
			ldown = true;
		}

		// exit
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			// rp.stop();
			rup = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			// rp.stop();
			rdown = false;
		}
		if (key == KeyEvent.VK_W) {
			// lp.stop();
			lup = false;
		}
		if (key == KeyEvent.VK_S) {
			// lp.stop();
			ldown = false;
		}

		
		if (!lup && !ldown)
			lp.stop();
		if (!rup && !rdown)
			rp.stop();

		
	}

}
