package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {
	private Logic logic;
	
	public Controller(PApplet app) {
		 logic= Logic.getInstance(app);
	}
	
	public void drawPlayers() {
		logic.drawPlayers();
	}

	public void recieveMessage(int player, String msg) {
		logic.recieveMessage(player,msg);
		
	}
	
	
}
