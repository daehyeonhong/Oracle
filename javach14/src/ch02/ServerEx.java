package ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {
	public static void main(String[] args) {
		try (BufferedReader in = null; /* 입력스트림 */
				BufferedWriter out = null; /* 출력스트림 */
				ServerSocket listner = null; /* 소캣 생성하는 서버 소켓 */
				Socket socket = null; /* 실제 통신을 담당하는 소켓 */
				Scanner scanner = new Scanner(System.in)) {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}