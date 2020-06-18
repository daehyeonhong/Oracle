package ch02;

import java.util.ArrayList;
import java.util.List;

public class ListExample6_R {
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

		List<Student_2> list3 = new ArrayList<Student_2>();
		list3.add(new Student_2("홍길동"));
		list3.add(new Student_2("일지매"));
		list3.add(new Student_2("임꺽정"));

		System.out.println(list3.contains(new Student_2("홍길동")));
	}
}

class Student_2 {
	String name;

	public Student_2(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student_2 [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student_2) {
			if (this.name.equals(((Student_2) obj).name)) {
				return true;
			}
		}
		return false;
	}

}