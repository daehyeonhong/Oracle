package ch01;

public class HashCodeMainExample {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동");
		Student s2 = new Student("홍길동");

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}

class Student extends Object {
	String name;

	// constructor
	public Student(String name) {
		this.name = name;
	}
}