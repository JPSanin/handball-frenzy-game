package view;

import communication.Session;
import communication.TCPLauncher;
import processing.core.PApplet;

public class MainView extends PApplet {
	private TCPLauncher launcher;
	private ConnectionView cv;
	private InstructionsView iv;
	private GameView gv;
	private int screen;
	private boolean p1Ready;
	private boolean p2Ready;
	private boolean finished;

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
		gv= new GameView(this);
		p1Ready=false;
		p2Ready=false;
		finished=false;
		
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
			if(p1Ready && p2Ready) {
				launcher.sendMessageToSessions("Players Ready");
				gv.startTime();
				screen=2;
			}
			break;
		case 2:
			gv.drawScreen();
			if(gv.goal()) {
				launcher.sendMessageToSessions(gv.goalMsg());
			}
			
			if(gv.isGameOver() && !finished) {
				launcher.sendMessageToSessions("game over");
				finished=true;
			}
			
			break;
		}
		/*textSize(20);
		text(mouseX+","+mouseY, mouseX,mouseY);*/

	}
	
	public void messageRecieved(Session s, String msg) {
		System.out.println("Message from session: "+s.getID()+" : "+msg );
		if(s.getID()==1 && msg.equals("Ready")) {
			p1Ready=true;
		}
		
		if(s.getID()==2 && msg.equals("Ready")) {
			p2Ready=true;
		}
		
		gv.recieveMessage(s.getID(),msg);
		
	}

}
