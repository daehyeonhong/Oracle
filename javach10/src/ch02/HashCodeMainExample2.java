package ch02;

public class HashCodeMainExample2 {
	public static void main(String[] args) {
		Student2 s1 = new Student2("홍길동", 20);
		Student2 s2 = new Student2("홍길동", 20);

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

		System.out.println("──────");
		Student2 s3 = new Student2("홍길동", 30);
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		System.out.println(s3.hashCode());
	}
}

class Student2 extends Object {
	String name;
	int age;

	// constructor
	public Student2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		return name.equals(((Student2) obj).name) & (age == ((Student2) obj).age);
	}
}