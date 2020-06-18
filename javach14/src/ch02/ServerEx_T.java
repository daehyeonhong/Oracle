package ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.Scanner;

public class ServerEx_T {
	public static void main(String[] args) {
		BufferedReader in = null; /* 입력스트림 */
		BufferedWriter out = null; /* 출력스트림 */
		ServerSocket listener = null; /* 소캣 생성하는 서버 소켓 */
		Socket socket = null; /* 실제 통신을 담당하는 소켓 */
		Scanner scanner = new Scanner(System.in);

		try {
			listener = new ServerSocket(9999);// 서버 소켓 생성
			System.out.println("연결을 기다리고 있습니다.");
			socket = listener.accept();// 클라이언트 연결시 소켓 생성
			System.out.println("연결되었습니다.");

			/* 통신 작업 시작 */
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 데이터 전송
			while (true) {
				String inputMessage = in.readLine();// 한 줄 단위로 읽기
				if (inputMessage.equalsIgnoreCase("bye")) {
					String text = "클라이언트에서 \"{0}\"로 연결을 종료하였습니다.";
					String result = MessageFormat.format(text, inputMessage);
					System.out.println(result);
					break;
				}
				System.out.println("클라이언트: " + inputMessage);
				System.out.print("보내기>>");
				String outputMessage = scanner.nextLine();// 키보드로부터 입력받기
				out.write(outputMessage + "\n");// 한 줄 단위로 읽도록 전달
				out.flush();// 메모리 데이터 밀어내기
			} // while 끝
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				socket.close();
				listener.close();
				out.close();
				in.close();
			} catch (Exception e2) {
				System.out.println("오류");
			}
		}
	}
}