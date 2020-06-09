package ch2_02;

public class AnnonymousMain {
	public static void main(String[] args) {
		AnnonymousMainExample anony = new AnnonymousMainExample();
		// 익명 객체 필드
		anony.field.wake();
		// 익명 객체 로컬 변수
		anony.method1();
		// 익명 객체 매개 값
		anony.method2(new Person() {
			void study() {
				System.out.println("공부합니다.");
			}

			@Override
			void wake() {// 부모 클래스에 있던 메소드
				System.out.println("8시에 일어납니다.");
				study();// 추가 된 메소드
			}
		});
	}
}