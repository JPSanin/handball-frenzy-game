package view;

import communication.Session;
import communication.TCPLauncher;
import processing.core.PApplet;

public class MainView extends PApplet {
	private TCPLauncher launcher;
	private ConnectionView cv;
	private InstructionsView iv;
	private int screen;

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
		screen=0;
		cv= new ConnectionView(this);
		iv= new InstructionsView(this);
	}

	public void draw() {
		background(0);
		switch(screen) {
		case 0:
			cv.drawScreen(launcher.getSessions().size());
			if(launcher.getSessions().size()==2) {
				launcher.sendMessageToSessions("Players Connected");
				screen=1;
			}
			break;
		case 1:
			iv.drawScreen();
			break;
		}

	}
	
	public void messageRecieved(Session s, String msg) {
		System.out.println("Message from session: "+s+" : "+msg  );
	}

}
