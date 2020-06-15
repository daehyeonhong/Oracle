package ch02;

import java.util.ArrayList;
import java.util.List;

public class ListExample5_R {
	public static void main(String[] args) {
		// Student 객체 "홍길동", "임꺽정", "일지매"를 저장 후 출력
		List<Student_1> list = new ArrayList<Student_1>();

		list.add(new Student_1("홍길동"));
		list.add(new Student_1("임꺽정"));
		list.add(new Student_1("일지매"));

		for (int i = 0; i < list.size(); i++) {
			Student_1 str = list.get(i);
			System.out.println(str);
		}

		for (Student_1 student_1 : list) {
			System.out.println(student_1);
		}
	}
}

class Student_1 {
	String name;

	public Student_1(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름: " + name;
	}

}