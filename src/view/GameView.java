package view;

import processing.core.PApplet;
import processing.core.PImage;

public class GameView {
	private PImage background;
	private PApplet app;
	
	
	public  GameView(PApplet app) {
		this.app = app;
		background= app.loadImage("../img/Game.png");
	}
	
	public void drawScreen() {
		app.image(background, 0, 0);
	}
}
