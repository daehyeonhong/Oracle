package ch04;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("채팅서버 ip를 입력하세요");
		String ip = sc.nextLine();
		System.out.println("접속할 이름을 입력하세요");
		String name = sc.nextLine();
		try {
			Socket socket = new Socket(ip, 6001);
			ReceiveThread rt = new ReceiveThread(socket);
			SendThread st = new SendThread(socket, name);
			rt.start();
			st.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}