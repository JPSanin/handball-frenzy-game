package model;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player {
	
	private PVector position;
	private PVector velocity;
	private PVector acceleration;
	
	private boolean posession, jumping, steal, shoot;
	private int player;
	
	
	private PImage playerImg;
	private PApplet app;
	
	public Player(int x, int y,int player,PApplet app) {
		position= new PVector(x,y);
		velocity= new PVector(0,0);
		acceleration= new PVector(0,0);
		posession=false;
		jumping=false;
		steal=false;
		shoot=false;
		this.player=player;
		if(player==1) {
			playerImg=app.loadImage("../img/p1.png");
		}else if(player==2) {
			playerImg=app.loadImage("../img/p2.png");
		}
		
	
		this.app = app;
	}
	
	
	public void draw() {
		if(position.x<=170 || position.x>=740) {
			acceleration.x=acceleration.x*-1;
			velocity.x=velocity.x*-1;
		}
		position.add(velocity);
		velocity.add(acceleration);
		app.image(playerImg, position.x, position.y);
		
		if(velocity.x>-1 && velocity.x<1) {
			acceleration.x=0;
			velocity.x=0;
		}
		
		
		
		if(position.y>=395) {
			jumping=false;
			position.y=400;
			velocity.y=0;
			acceleration.y=0;
		}
		
	
	}
	
	public void move(String movement) {
		
		if(movement.equals("left")) {
			velocity.x=-10;
			acceleration.x=0.5f;	
		}
		
		if(movement.equals("right")) {
			velocity.x=10;
			acceleration.x=-0.5f;
		}
		
		if(movement.equals("jump") && !jumping) {
			jumping=true;
			velocity.y=-30;
			acceleration.y= 1.2f;
		}
	}

	
	
	

	public PVector getPosition() {
		return position;
	}


	public boolean isSteal() {
		return steal;
	}


	public void setSteal(boolean steal) {
		this.steal = steal;
	}


	public boolean isShoot() {
		return shoot;
	}


	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}


	public boolean isPosession() {
		return posession;
	}


	public void setPosession(boolean posession) {
		this.posession = posession;
	}


	public boolean isJumping() {
		return jumping;
	}


	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}


	public int getPlayer() {
		return player;
	}


	public void setPlayer(int player) {
		this.player = player;
	}


	public void setPosition(PVector position) {
		this.position = position;
	}


	
	
	
}
