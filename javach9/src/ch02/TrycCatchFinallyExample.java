package ch02;

public class TrycCatchFinallyExample {
	public static void main(String[] args) {
		try {
			String data = null;
			data = "hello";// 문자열로 값 대입
			System.out.println(data.length());
			System.out.println(data.toString());
			System.out.println("여기까지 실행");
		} catch (Exception e) {
			// 예외 처리 부분
			System.out.println("예외 메시지" + e.getMessage());
		} finally {
			System.out.println("종료 시 예외 발생과 상관 없이 반드시 처리해야하는 부분");
		}
	}
}