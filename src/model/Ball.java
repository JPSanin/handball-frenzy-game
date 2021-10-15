package model;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Ball {

	private static final int NONE = 0;
	private static final int PLAYER1 = 1;
	private static final int PLAYER2 = 2;

	private PVector position;
	private PVector velocity;
	private PVector gravity;

	private int posession;

	private PImage ballImg;
	private PApplet app;

	public Ball(PApplet app) {
		position = new PVector(464, 15);
		velocity = new PVector(0, 0);
		gravity = new PVector(0, 0.2f);
		posession = NONE;
		ballImg = app.loadImage("../img/ball.png");
		this.app = app;
	}

	public void draw() {
		// Only if no one has it
		if (posession == NONE) {
			// Add velocity to the location.
			position.add(velocity);
			// Add gravity to velocity
			velocity.add(gravity);

			// Reset
			if ((position.x > 1000) || (position.x < 0)) {
				position.x = 464;
				position.y = 15;
				velocity.x=0;
				velocity.y=0;
			}
			// Bounce off edges
			if (position.y > 444) {

				velocity.y = (float) (velocity.y * -0.4f);
				position.y = 445;
			}
		}

		app.image(ballImg, position.x, position.y);
	}

	public void shoot(int x, int y, int player) {

	}

	public void changePosession(float x, float y, int player) {
		posession = player;
		position.x = x;
		position.y = y;
	}



	public PVector getPosition() {
		return position;
	}

	public void setPosition(PVector position) {
		this.position = position;
	}

	public PVector getVelocity() {
		return velocity;
	}

	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}

	public int getPosession() {
		return posession;
	}
	
	
	
	
	

}
