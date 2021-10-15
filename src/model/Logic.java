package model;

import processing.core.PApplet;

public class Logic {
	
	private Player p1;
	private Player p2;
	
	private Scoreboard sb;
	
	private PApplet app;
	private static Logic onlyInstance;
	
	private Logic(PApplet app) {
		this.app=app;
		p1= new Player(180,400,1,app);
		p2= new Player(710,400,2,app);
	}


	public static Logic getInstance(PApplet app) {
		if(onlyInstance == null) {
			onlyInstance = new Logic(app);
		}
		return onlyInstance;
	}
	
	
	public void drawPlayers() {
		p1.draw();
		p2.draw();
	}

	public void recieveMessage(int player, String msg) {
		if(player==1) {
			p1.move(msg);
		}
		
		if(player==2) {
			p2.move(msg);
		}
	}
	
	
	public PApplet getApp() {
		return app;
	}


	
	
	

}
