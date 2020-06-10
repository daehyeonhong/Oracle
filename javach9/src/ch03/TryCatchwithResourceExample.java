package ch03;

import java.util.Scanner;

public class TryCatchwithResourceExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			String message = scanner.next();
			int intNum = Integer.parseInt(message);
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();// 자원 해제
		}
	}
}