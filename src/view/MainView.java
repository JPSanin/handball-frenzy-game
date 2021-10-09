package view;

import communication.Session;
import communication.TCPLauncher;
import processing.core.PApplet;

public class MainView extends PApplet {
	private TCPLauncher launcher;

	public static void main(String[] args) {
		PApplet.main(MainView.class.getName());
	}

	public void settings() {
		size(1000, 600);

	}

	public void setup() {
		launcher= TCPLauncher.getInstance();
		launcher.setMain(this);
		launcher.start();
	}

	public void draw() {
		background(0);

	}
	
	public void messageRecieved(Session s, String msg) {
		System.out.println("Message from session: "+s+" : "+msg  );
	}

}
