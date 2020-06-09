package ch01_02;

public class AMainExample {
	public static void main(String[] args) {
		// static member 객체 생성
		A.B b = new A.B();
		b.field1 = 3;// instance member에 접근
		b.field2 = 3;// static member에 접근
		b.method1();// instance member에 접근
		b.method2();// static member에 접근
	}
}