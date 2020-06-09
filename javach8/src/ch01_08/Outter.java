package ch01_08;

public class Outter {
	// 바깥 클래스의 맴버
	String field = "Outer-field";

	void method() {
		System.out.println("Outter-method");
	}

	class Nested {
		String field = "Nested-field";

		void method() {
			System.out.println("Nested-method");
		}

		void print() {
			System.out.println(this.field);// 내부 클래스의 필드
			this.method();// 내부 클래스의 메소드

			System.out.println(Outter.this.field);// 외부 클래스의 필드
			Outter.this.method();// 외부 클래스의 메소드
		}
	}
}