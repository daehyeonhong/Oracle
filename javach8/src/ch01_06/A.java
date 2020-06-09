package ch01_06;

public class A {
	int field1;
	static int field2;
	void method1() {}
	static void method2() {}
	static class c{// static member로 선언 된 클래스 내부에서 바깥 쪽 member에 접근 시
		void method() {
			// field1=2;--instance member는 접근 불가
			field2=10;// static member는 접근 가능
			// method1();
			method2();
		}
	}
}