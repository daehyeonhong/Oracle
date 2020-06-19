package ch04;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;

public class PerClient extends Thread {
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<>());
	Socket socket;
	PrintWriter pw;
	String name;

	public PerClient(Socket socket) throws IOException {
		this.socket = socket;
		pw = new PrintWriter(socket.getOutputStream());
		list.add(pw);
	}

	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = br.readLine();
			sendAll("# " + name + "님이 들어오셨습니다");
			while (true) {
				String msg = br.readLine();
				if (msg == null)
					break;
				sendAll(name + " > " + msg);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			list.remove(pw);
			sendAll("# " + name + "님이 나가셨습니다.");
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

	public void sendAll(String str) {
		for (PrintWriter client : list) {
			client.println(str);
			client.flush();
		}
	}
}