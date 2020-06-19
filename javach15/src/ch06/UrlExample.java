package ch06;

import java.net.URL;
import java.util.Scanner;

public class UrlExample {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			System.out.print("URL을 입력하세요> ");
			String str = scanner.nextLine();
			URL url = new URL(str);
			System.out.println("프로토콜: " + url.getProtocol());
			System.out.println("파일: " + url.getFile());
			System.out.println("포트: " + url.getPort());
			System.out.println("Host: " + url.getHost());
			System.out.println("Content: " + url.getContent());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}