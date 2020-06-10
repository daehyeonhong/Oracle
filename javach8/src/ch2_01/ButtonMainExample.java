package ch2_01;

import ch2_01.Button.OnClickListener;

public class ButtonMainExample {
	public static void main(String[] args) {
		Button btn = new Button();

		// 구현체인 CallListener가 OnClickListener타입으로 프로모션 되어 대입.
		// 매개 변수의 다형성
		btn.setOnClickListener(new CallListener());
		btn.touch();// 구현체의 재정의된 메소드 실행
		// 구현체인 MessageListener가 OnClickListener타입으로 프로모션 되어 대입.
		// 매개 변수의 다형성
		btn.setOnClickListener(new MessageListener());
		btn.touch();// 구현체의 재정의된 메소드 실행

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick() {
				System.out.println("인터페이스 객체의 메소드 실행.");

			}
		});
		btn.touch();
	}
}