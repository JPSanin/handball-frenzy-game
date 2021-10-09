package view;

import processing.core.PApplet;
import processing.core.PImage;

public class InstructionsView {
	private PImage background;
	private PApplet app;
	
	
	public  InstructionsView(PApplet app) {
		this.app = app;
		background= app.loadImage("../img/Instructions.png");
	}
	
	public void drawScreen() {
		app.image(background, 0, 0);
	}
	
	
}
