package ch01;

public class A {
	class B {// instance member
		B() {
		}// 생성자

		int field1;// instance field
		// static int field2; --instance member 내부에는 static멤버가 올 수 없음.

		void method1() {
		}
		// static void method2() {} -- instance member 내부에는 static멤버가 올 수 없음.
	}
}