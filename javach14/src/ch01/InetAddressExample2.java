package ch01;

import java.net.InetAddress;
import java.util.Scanner;

public class InetAddressExample2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("ip를 확인할 도메인> ");
			// 상대 IP 도메인과 주소 매핑정보 얻기 InetAddress
			String url = scanner.nextLine();
			InetAddress ia = InetAddress.getByName(url);
			System.out.println(url + ": " + ia.getHostAddress());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}