package ch04;

import java.util.HashMap;
import java.util.Scanner;

public class MapExample7_A {
	public static void main(String[] args) {
		//
		HashMap<String, Student> map = new HashMap<String, Student>();

		// 3명의 학생 저장
		map.put("홍길동", new Student(1, "010-111-1234"));
		map.put("일지매", new Student(2, "010-111-3333"));
		map.put("임꺽정", new Student(3, "010-111-1212"));

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.print("검색할 이름: ");
				String name = scanner.nextLine();
				if (name.equals("exit")) {
					System.out.println("종료합니다.");
					break;
				}

				Student student = map.get(name);

				if (!map.containsKey(name)) {
					System.out.println(name + "은(는) 없는 사람입니다.");
				} else {
					System.out.println("id: " + student.getId() + ",tel: " + student.getTel());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
