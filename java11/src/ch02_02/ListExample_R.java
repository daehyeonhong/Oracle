package ch02_02;

import java.util.LinkedList;
import java.util.Scanner;

public class ListExample_R {
	public static void main(String[] args) {
		// 문자열 삽입 가능한 List
		LinkedList<String> list = new LinkedList<String>();

		// 키보드로부터 4개의 이름 입력
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 0; i < 4; i++) {
				System.out.print("이름을 입력하세요> ");
				String name = scanner.next();
				list.add(name);
			}

			// 입력된 문자열의 갯수
			for (int i = 0; i < list.size(); i++) {
				String name = list.get(i);
				System.out.println(name);
			}

			// 가장 긴 이름 출력
			int longLengthIndex = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(longLengthIndex).length() < list.get(i).length()) {
					longLengthIndex = i;
				}
			}

			System.out.println("\n가장 긴 이름: " + list.get(longLengthIndex));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}