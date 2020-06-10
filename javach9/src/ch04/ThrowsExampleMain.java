package ch04;

public class ThrowsExampleMain {
	public static void main(String[] args) {
		Throws1 throws1 = new Throws1();
		throws1.method1();
	}
}

class Throws1 {
	public void method1() {
		try {
			// method를 호출하는 쪽에서 예외 처리해줘야 함.
			method2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 호출되는 메소드에서 throws로 예외를 던지는 형태인 경우
	public void method2() throws Exception {
		throw new Exception("method2()에서 발생한 예외");
	}
}