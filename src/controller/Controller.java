package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {
	private Logic logic;
	
	public Controller(PApplet app) {
		 logic= Logic.getInstance(app);
	}
	
	public void drawElements() {
		logic.drawElements();
	}

	public void recieveMessage(int player, String msg) {
		logic.recieveMessage(player,msg);
		
	}

	public void startTime() {
		logic.startTime();
		
	}

	public String getTime() {
		return logic.getTime();
	}

	public int getP1Goals() {
		return logic.getP1Goals();
	}
	
	public int getP2Goals() {
		return logic.getP2Goals();
	}
	
}
