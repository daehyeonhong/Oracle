package ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx_T {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			// 소켓 생성
			socket = new Socket("localhost", 9999);

			// 스트림 생성
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 대화 작업
			while (true) {
				System.out.print("보내기>>");
				String outputMessage = scanner.nextLine();// 한 줄 단위로 입력 받기
				if (outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n");// 서버로 종료 메시지 보내고
					out.flush();// 버퍼 비우기
					break;// 종료
				}
				out.write(outputMessage + "\n");// 한 줄 읽어들이도록 전송
				out.flush();// 버퍼 비우기
				String inputMessage = in.readLine();// 서버로부터 전달된 메시지를 한 줄씩 읽기
				System.out.println("서버: " + inputMessage);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				if (socket != null) {
					socket.close();// 클라이언트 소켓 해제
				}
				out.close();
				in.close();
			} catch (Exception e) {

			}
		}
	}
}