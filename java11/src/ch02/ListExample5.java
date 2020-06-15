package ch02;

import java.util.ArrayList;
import java.util.List;

public class ListExample5 {
	public static void main(String[] args) {
		// Student 객체 "홍길동", "임꺽정", "일지매"를 저장 후 출력하는 list
		List<Student> list = new ArrayList<Student>();

		list.add(new Student("홍길동"));
		list.add(new Student("임꺽정"));
		list.add(new Student("일지매"));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (Student student : list) {
			System.out.println(student);
		}
	}
}

class Student {
	String name;

	public Student(String name) {
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