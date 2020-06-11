package ch05;

public class FinalizeExample {
	public static void main(String[] args) {
		NewCounter nc = null;
		for (int i = 0; i <= 10; i++) {
			nc = new NewCounter(i);// i번째 객체 생성
			System.out.println(i + "객체 생성");
			nc = null;// i번째 객체와 참조 변수가 끊어짐 - 쓰레기
			System.gc();// 쓰레기 제거 - finalize() 실행
		}
	}
}