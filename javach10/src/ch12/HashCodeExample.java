package ch12;

import java.util.Objects;

public class HashCodeExample {
	public static void main(String[] args) {
		// hash(필드1,필드2,...) hashCode 값 생성
		// hashCode(객체 참조 변수) hashCode 값 리턴
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
		System.out.println(s1.hashCode());
		System.out.println(Objects.hashCode(s1));
		System.out.println(s2.hashCode());
		System.out.println(Objects.hashCode(s2));
	}
}

class Student {
	int sno;
	String name;

	@Override
	public int hashCode() {
		return Objects.hash(sno, name);
	}

	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
}