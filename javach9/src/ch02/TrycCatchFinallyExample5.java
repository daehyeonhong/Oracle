package ch02;

public class TrycCatchFinallyExample5 {
	public static void main(String[] args) {
		try {
			String data = null;
			data = "hello";// 문자열로 값 대입
			System.out.println(data.length());
			String[] strings = { "hello", "hi" };
			System.out.println(strings[1]);
			double result = 5 / 0;

		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("null point | 배열 인덱스 예외 발생!");
		} catch (Exception e) {
			// 예외 처리 부분
			System.out.println("예외 메시지" + e.getMessage());
		} finally {
			System.out.println("종료 시 예외 발생과 상관 없이 반드시 처리해야하는 부분");
		}
	}
}