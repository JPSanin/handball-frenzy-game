package model;

import processing.core.PApplet;
import processing.core.PVector;

public class Logic {

	private Player p1;
	private Player p2;
	private Ball b;
	private Scoreboard sb;
	private String goalMsg;

	private PApplet app;
	private static Logic onlyInstance;

	private Logic(PApplet app) {
		this.app = app;
		p1 = new Player(180, 400, 1, app);
		p2 = new Player(710, 400, 2, app);
		b = new Ball(app);
		sb = new Scoreboard();
	}

	public static Logic getInstance(PApplet app) {
		if (onlyInstance == null) {
			onlyInstance = new Logic(app);
		}
		return onlyInstance;
	}

	public void drawElements() {
		p1.draw();
		p2.draw();
		b.draw();
		grabBall();

	}

	public boolean goal() {
		boolean goal = false;
		if (b.getPosition().x <= 114 && b.getPosition().y >= 310) {
			goal = true;
			goalMsg = "2,goal";
			// Reset
			b.setPosition(new PVector(464, 15));
			b.setVelocity(new PVector(0, 0));
			
			p1.setPosition(new PVector(180, 400));
			p2.setPosition(new PVector(710, 400));
			sb.setP2goals(getP2Goals() + 1);
		}

		if (b.getPosition().x >= 815 && b.getPosition().y >= 310) {
			goal = true;
			goalMsg = "1,goal";
			// Reset
			b.setPosition(new PVector(464, 15));
			b.setVelocity(new PVector(0, 0));
			sb.setP1goals(getP1Goals() + 1);
		}

		return goal;

	}

	public void grabBall() {
		// W 110 H120
		// Check grab
		if (PApplet.dist(p1.getPosition().x+55,p1.getPosition().y+60,b.getPosition().x+36,b.getPosition().y+36)<55 && !p2.isPosession()) {
			b.changePosession(p1.getPosition().x+55, p1.getPosition().y+30,1);
			p1.setPosession(true);
			return;
		}else {
			b.changePosession(b.getPosition().x, b.getPosition().y,0);
		}
		
		if (PApplet.dist(p2.getPosition().x+55,p2.getPosition().y+60,b.getPosition().x+36,b.getPosition().y+36)<55 && !p1.isPosession()  && !p1.isPosession()) {
			b.changePosession(p2.getPosition().x, p2.getPosition().y+40,2);
			p2.setPosession(true);
		}else {
			b.changePosession(b.getPosition().x, b.getPosition().y,0);
		}
		/*System.out.println("possesion: "+b.getPosession());
		System.out.println("x: "+b.getPosition().x);
		System.out.println("y: "+b.getPosition().y);*/
	}

	public String goalMsg() {
		return goalMsg;
	}

	public void recieveMessage(int player, String msg) {
		if (player == 1) {
			if(msg.equals("steal")) {
				if (PApplet.dist(p1.getPosition().x+55,p1.getPosition().y+60,b.getPosition().x+36,b.getPosition().y+36)<55 && p2.isPosession()) {
					b.changePosession(p1.getPosition().x+55, p1.getPosition().y+30,1);
					p1.setPosession(true);
					p2.setPosession(false);
				}
			}else if(msg.equals("shoot")&& p1.isPosession()) {
				b.changePosession(b.getPosition().x+56, b.getPosition().y+30,0);
				p1.setPosession(false);
				b.shoot(7.5f, 0);
			}else {
				p1.move(msg);
			}
			
		}

		if (player == 2) {
			if(msg.equals("steal")) {
				if (PApplet.dist(p2.getPosition().x+55,p2.getPosition().y+60,b.getPosition().x+36,b.getPosition().y+36)<55 && !p1.isPosession()  && !p1.isPosession()) {
					b.changePosession(p2.getPosition().x, p2.getPosition().y+40,2);
					p2.setPosession(true);
					p1.setPosession(false);
				}
			}else if(msg.equals("shoot")) {
				b.changePosession(b.getPosition().x-56, b.getPosition().y+30,0);
				p2.setPosession(false);
				b.shoot(-7.5f, 0);
			}else {
				p2.move(msg);
			}
			
		}

	}

	public PApplet getApp() {
		return app;
	}

	public void startTime() {
		sb.start();
	}

	public String getTime() {
		return sb.getTime();

	}

	public int getP1Goals() {
		return sb.getP1goals();
	}

	public int getP2Goals() {
		return sb.getP2goals();
	}

}
