package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class GameView {
	private PImage background, winner1, winner2;
	private Controller controller;
	private PFont font;
	private PApplet app;
	
	
	public  GameView(PApplet app) {
		this.app = app;
		background= app.loadImage("../img/Game.png");
		winner1= app.loadImage("../img/winner1.png");
		winner2= app.loadImage("../img/winner2.png");
		font= app.createFont("../fonts/SignikaNegative-Regular.ttf", 30);
		controller= new Controller(app);
	}
	
	public void drawScreen() {
		if(!isGameOver()) {
			app.image(background, 0, 0);
			app.fill(255);
			app.textFont(font);
			app.textAlign(PConstants.CENTER);
			app.text(controller.getTime(),500,145);
			app.textSize(40);
			app.text(controller.getP1Goals(),465,95);
			app.text(controller.getP2Goals(),535,95);
			controller.drawElements();
		}else {
			if(controller.getWinner()==1) {
				app.image(winner1, 0, 0);
			}else if(controller.getWinner()==2) {
				app.image(winner2, 0, 0);
			}
		}
		
		
	}
	
	
	public void recieveMessage(int player, String msg) {
		controller.recieveMessage(player,msg);
	}
	
	public void startTime() {
		controller.startTime();
	}

	public boolean goal() {
		return controller.goal();
	}
	
	public String goalMsg() {
		return controller.goalMsg();
	}

	public boolean isGameOver() {
		return controller.isGameOver();
	}
}
