package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class GameView {
	private PImage background;
	private Controller controller;
	private PFont font;
	private PApplet app;
	
	
	public  GameView(PApplet app) {
		this.app = app;
		background= app.loadImage("../img/Game.png");
		font= app.createFont("../fonts/SignikaNegative-Regular.ttf", 30);
		controller= new Controller(app);
	}
	
	public void drawScreen() {
		app.image(background, 0, 0);
		app.fill(255);
		app.textFont(font);
		app.textAlign(PConstants.CENTER);
		app.text(controller.getTime(),500,145);
		app.textSize(40);
		app.text(controller.getP1Goals(),465,95);
		app.text(controller.getP2Goals(),535,95);
		controller.drawElements();
	}
	
	
	public void recieveMessage(int player, String msg) {
		controller.recieveMessage(player,msg);
	}
	
	public void startTime() {
		controller.startTime();
	}
}
