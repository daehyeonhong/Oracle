package ch01_05;

public class A {
	int field1;
	static int field2;
	void method1() {}
	static void method2() {}
	class B{//instance member로 선언 된 클래스에서는
		void methid() {
			field1=2;//바깥 쪽 instance member
			field2=10;//static member 모두 접근 가능
			method1();
			method2();
		}
	}
}