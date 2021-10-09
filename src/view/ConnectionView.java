package view;

import processing.core.PApplet;
import processing.core.PImage;

public class ConnectionView {
	
	private PImage background, connecting1, connecting2, connected1, connected2;
	private PApplet app;
	
	
	public  ConnectionView(PApplet app) {
		this.app = app;
		background= app.loadImage("../img/backgroundStart.png");
		connecting1= app.loadImage("../img/connecting1.png");
		connecting2= app.loadImage("../img/connecting2.png");
		connected1= app.loadImage("../img/connected1.png");
		connected2= app.loadImage("../img/connected2.png");
		
	}
	
	public void drawScreen(int bg) {
		app.image(background, 0, 0);
		switch(bg) {
		case 0:
			if(app.frameCount%50<30) {
				app.image(connecting1, 159, 408);
				app.image(connecting2, 536, 408);
			}
			
			break;
		case 1:
			app.image(connected1, 159, 408);
			if(app.frameCount%50<30) {
				
				app.image(connecting2, 536, 408);
			}
			break;
		case 2:
			app.image(connected1, 159, 408);
			app.image(connected2, 536, 408);
			break;
			
		}
	}



}
