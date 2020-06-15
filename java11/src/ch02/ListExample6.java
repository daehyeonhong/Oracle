package ch02;

import java.util.ArrayList;
import java.util.List;

public class ListExample6 {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();

		list1.add(10);
		list1.add(20);
		list1.add(30);

		System.out.println(list1.contains(20));
		System.out.println(list1.contains(40));

		List<String> list2 = new ArrayList<String>();
		list2.add("홍길동");
		list2.add("일지매");
		list2.add("임꺽정");

		System.out.println(list2.contains("일지매"));
		System.out.println(list2.contains("이순신"));

		List<Student1> list3 = new ArrayList<Student1>();
		list3.add(new Student1("홍길동"));
		list3.add(new Student1("일지매"));
		list3.add(new Student1("임꺽정"));

		// 사용자 정의 객체의 경우
		// hashCode() method와 equals()method를 재정의한 후 사용
		// true결과를 리턴 - 논리적 동등
		System.out.println(list3.contains(new Student1("홍길동")));
	}
}

class Student1 {
	String name;

	public Student1(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름: " + name;
	}

	// @Override
	// public int hashCode() {
	// return this.name.hashCode();
	// }

	// @Override
	// public boolean equals(Object obj) {
	// if (obj instanceof Student1) {
	// Student1 student = (Student1) obj;
	// return (name.equals(student.name) ? true : false);
	// }
	// return false;
	// }

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object obj) {
		return name.equals(((Student1) obj).name);
	}
}