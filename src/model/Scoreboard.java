package model;



public class Scoreboard extends Thread {

	private int p1goals, p2goals;
	private String timeDisplay;
	private int timeStart;
	long delay;

	private boolean timesUp;


	public Scoreboard() {
		p1goals = 0;
		p2goals = 0;
		timeStart = 120;
		timesUp = false;
		timeDisplay = "2:00";
		delay=timeStart * 1000;
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
		timeDisplay = "0:00";
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

	public void setP1goals(int p1goals) {
		this.p1goals = p1goals;
	}

	public void setP2goals(int p2goals) {
		this.p2goals = p2goals;
	}

	public boolean isTimesUp() {
		return timesUp;
	}

	public void setTimesUp(boolean timesUp) {
		this.timesUp = timesUp;
	}
	
	
	
	

	

}
