package ch02_02;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListExample {
	public static void main(String[] args) {
		// 문자열 삽입 가능한 List
		// LinkedList<String> list = new LinkedList<String>();
		List<String> list = new ArrayList<String>();

		// 키보드로부터 4개의 이름 입력
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 0; i < 4; i++) {// list.size()는 저장된 갯수, 현재는 0
				System.out.println("이름을 입력하세요");
				String s = scanner.next();
				list.add(s);
			}

			// 입력된 문자열 갯수
			for (int i = 0; i < list.size(); i++) {// list.size() = 4
				String name = list.get(i);
				System.out.println(name);
			}

			// 가장 긴 이름 출력
			int longIndex = 0;// 인덱스번호 저장용 변수 선언
			for (int i = 0; i < list.size(); i++) {
				if (list.get(longIndex).length() < list.get(i).length()) {
					longIndex = i;
				}
			}

			System.out.println("\n가장 긴 이름은: " + list.get(longIndex));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}