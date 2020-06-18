package ch03;

import java.util.HashSet;
import java.util.Set;

public class SetMainExample {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(10);
		set1.add(30);

		System.out.println(set1);

		Set<String> set2 = new HashSet<String>();
		set2.add("홍길동");
		set2.add("일지매");
		set2.add("임꺽정");
		set2.add("홍길동");

		System.out.println(set2);

		Set<Student> set3 = new HashSet<Student>();
		set3.add(new Student("홍길동"));
		set3.add(new Student("일지매"));
		set3.add(new Student("임꺽정"));
		set3.add(new Student("홍길동"));

		System.out.println(set3);
	}
}

class Student {
	String name;

	public Student(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름: " + name;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			return name.equals(((Student) obj).name);
		}
		return false;
	}
}