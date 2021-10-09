package communication;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import view.MainView;

public class Session extends Thread{
	
	private BufferedWriter bw;
	private MainView observer;
	private Socket socket;
	private int id;
	
	public Session(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
	 
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader breader = new BufferedReader(isr);
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw= new OutputStreamWriter(os);
			bw= new BufferedWriter(osw);

			while (true) {

				System.out.println("Esperando mensaje...");
				String msg = breader.readLine();
				System.out.println(msg);
				observer.messageRecieved(this, msg);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String msg) {
		new Thread(
				()->{
					
					try {
						
						bw.write(msg+"\n");
						bw.flush();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
				}).start();
	}

	public void setObserver(MainView observer) {
		this.observer = observer;
	}

	public void setID(int id) {
		this.id=id;
	}
}
