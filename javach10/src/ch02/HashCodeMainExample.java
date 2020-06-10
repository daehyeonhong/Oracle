package ch02;

public class HashCodeMainExample {
	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

		System.out.println("──────");
		Student s3 = new Student(2, "임꺽정");
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		System.out.println(s3.hashCode());
	}
}

class Student extends Object {
	int sno;
	String name;

	// constructor
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return sno;// 리턴 값이 기본 타입인 INT
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return sno == ((Student) obj).sno;// 비교 대상이 기본 타입 INT
	}
}