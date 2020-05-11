package broker.three.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JuryThread extends Thread{
	Socket s;
	Database db;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public JuryThread(Socket s, Database db) {
		this.s = s;
		this.db = db;
	}

	public void run() {
		System.out.println("jury....run()....");
		
	}
}
