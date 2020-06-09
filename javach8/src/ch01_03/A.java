package ch01_03;

public class A {
	// method 안에 선언 된 local class
	void method() {
		class D {// local class
			D() {
				System.out.println("로컬 클래스 생성");
			}

			int field1;// instance member
			// static int field2;// static member

			void method1() {
				System.out.println(field1);
			}// instance member
				// static void method2() {}// static member
		}// class init
		D d = new D();
		d.field1 = 3;
		d.method1();
	}// method
}