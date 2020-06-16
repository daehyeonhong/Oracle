package ch07;

import java.util.Objects;
import java.util.TreeSet;

public class ComparableExample {
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>();
		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("일지매", 25));
		treeSet.add(new Person("임꺽정", 31));
		for (Person p : treeSet) {
			System.out.println(p.getName() + ", " + p.getAge());
		}
	}
}

class Person implements Comparable<Person> {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if (o instanceof Person) {
			System.out.println(Objects.hash(name, age) - Objects.hash(o.name, o.age));
			return Objects.hash(name, age) - Objects.hash(o.name, o.age);
		}
		return 0;
	}
}