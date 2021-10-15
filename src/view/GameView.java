package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

public class GameView {
	private PImage background;
	private Controller controller;
	private PApplet app;
	
	
	public  GameView(PApplet app) {
		this.app = app;
		background= app.loadImage("../img/Game.png");
		controller= new Controller(app);
		
	}
	
	public void drawScreen() {
		app.image(background, 0, 0);
		controller.drawPlayers();
	}
	
	
	public void recieveMessage(int player, String msg) {
		controller.recieveMessage(player,msg);
	}
}
