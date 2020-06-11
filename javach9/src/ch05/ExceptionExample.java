package ch05;

public class ExceptionExample {
	public static void main(String[] args) {
		try {
			method();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 사용자 정의 예외 객체 생성
	public static void method() throws NumberException {
		throw new NumberException("숫자오류메시지");
	}
}