package ch01;

public class HashCodeMainExample2 {
	public static void main(String[] args) {
		Student1 s1 = new Student1("홍길동");
		Student1 s2 = new Student1("홍길동");

		// hashCode() return 값 조작
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

		System.out.println(s1 == s2);
		// .equals() return 값 조작
		System.out.println(s1.equals(s2));
	}
}

class Student1 extends Object {
	String name;

	// constructor
	public Student1(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.length();
	}

	@Override
	public boolean equals(Object obj) {// Student1 -> Object로 promotion
		return name.equals(((Student1) obj).name);// [field_name]과 argument 값 obj 내용이 같으면 true
	}
}