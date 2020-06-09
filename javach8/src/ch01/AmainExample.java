package ch01;

public class AmainExample {
	public static void main(String[] args) {
		// 바깥 쪽 클래스 생성 후
		A a = new A();
		// 안 쪽 클래스 생성
		// A.B b = 변수.new 안 쪽 객체 생성자();
		A.B b = a.new B();
		// 안 쪽 클래스의 멤버에 접근
		b.field1 = 3;
		b.method1();
	}
}