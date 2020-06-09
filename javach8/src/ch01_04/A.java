package ch01_04;

public class A {
	// instance field
	B field1 = new B();
	C field2 = new C();

	// instance method
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}

	// static field 초기화
	// static B field3 = new B();--B가 instance member이므로 static 불가
	static C field4 = new C();// C가 static이므로 가능
	// static method

	static void method2() {
		// B var1 = new B();--B가 instance member 이므로 static method에 올 수 없음
		C var2 = new C();// C가 static이므로 가능
	}

	// instance member
	class B {}
	// static member
	static class C {}
}