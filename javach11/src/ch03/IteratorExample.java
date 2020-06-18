package ch03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();

		list.add(new Student("홍길동"));
		list.add(new Student("일지매"));
		list.add(new Student("임꺽정"));
		list.add(new Student("홍길동"));

		Iterator<Student> itor = list.iterator();

		System.out.println("──────────");

		while (itor.hasNext()) {
			System.out.println(itor.next());
		}

		System.out.println("──────────");

		for (Student s : list) {
			System.out.println(s);
		}

		System.out.println("──────────");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.print("──────────");
	}
}