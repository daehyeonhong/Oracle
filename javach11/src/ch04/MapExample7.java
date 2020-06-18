package ch04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample7 {
	public static void main(String[] args) {
		//
		Map<String, Student> map = Collections.synchronizedMap(new HashMap<String, Student>());

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

				if (student == null) {
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

class Student {
	int id;
	String tel;

	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}