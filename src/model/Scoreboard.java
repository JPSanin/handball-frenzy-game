package model;

import processing.core.PApplet;

public class Scoreboard extends Thread {

	private int p1goals, p2goals;
	private String timeDisplay;
	private int timeStart;
	long delay;

	private boolean timesUp;

	private PApplet app;

	public Scoreboard(PApplet app) {
		p1goals = 0;
		p2goals = 0;
		timeStart = 120;
		timesUp = false;
		timeDisplay = "2:00";
		delay=timeStart * 1000;
		this.app = app;
	}

	public void run() {
		do {

			try {
				int minutes = timeStart / 60;
				int seconds = timeStart % 60;
				timeDisplay=minutes+":"+seconds;
				//System.out.println(minutes + " minute(s), " + seconds + " second(s)");
				Thread.sleep(1000);
				timeStart = timeStart - 1;
				delay = delay - 1000;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} while (delay != 0);
		timesUp=true;
		//System.out.println("Time's Up!");
	}
	
	

	public String getTime() {
		return timeDisplay;
	}

	public int getP1goals() {
		return p1goals;
	}

	public int getP2goals() {
		return p2goals;
	}
	
	

	

}
