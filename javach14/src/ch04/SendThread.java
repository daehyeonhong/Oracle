package ch04;

import java.net.*;
import java.io.*;

public class SendThread extends Thread {
	Socket socket;
	String name;

	public SendThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	public void run() {
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(name);
			pw.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String msg = br.readLine();
				if (msg.equals("bye"))
					break;
				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}
}