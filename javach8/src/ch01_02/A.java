package ch01_02;

//static member로 선언된 내부 클래스
public class A {
	static class B {// static member
		B() {
		}

		int field1;// instance member
		static int field2;// static member

		void method1() {
		}// instance member

		static void method2() {
		}// static member
	}
}