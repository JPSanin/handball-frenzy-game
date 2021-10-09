package communication;

import view.MainView;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class TCPLauncher extends Thread {

	private MainView observer;
	private ServerSocket server;
	private ArrayList<Session> sessions;

	private static TCPLauncher uniqueTCP;

//Private constructor for singleton implementation
	private TCPLauncher() {
		sessions= new ArrayList<>();
	}

	// Static method for getting the only instance of this class
	public static TCPLauncher getInstance() {
		if (uniqueTCP == null) {
			uniqueTCP = new TCPLauncher();
		}
		return uniqueTCP;
	}

	@Override
	public void run() {
		try {
			
			//Accept Connections
			server = new ServerSocket(5000);
			int s=1;
			while(s<3) {
				System.out.println("Esperando cliente en el 5000...");
				Socket socket = server.accept();
				Session session= new Session(socket);
				session.setObserver(observer);
				session.setID(s);
				session.start();
				sessions.add(session);
				System.out.println("Cliente "+s+ " Conectado");
				session.sendMessage(""+s);
				s++;
			}
			
			sendMessageToSessions("Players Connected");

			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Subscription
	public void setMain(MainView observer) {
		this.observer = observer;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}
	
	public void sendMessageToSessions(String msg) {
		for(int i=0; i< sessions.size(); i++) {
			sessions.get(i).sendMessage(msg);
		}
	}
	
}
