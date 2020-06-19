package ch04;

import java.io.*;
import java.net.*;

public class ServerEx {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6001);
			while (true) {
				Socket sock = ss.accept();
				PerClient th = new PerClient(sock);
				th.start();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}