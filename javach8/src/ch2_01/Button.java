package ch2_01;

public class Button {
	OnClickListener listener;// 멤버 필드 선언
	
	// Button 클래스의 멤버로 인터페이스 선언
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	void touch() {
		listener.onClick();// 구현체의 click메소드 호출
	}

	// Button 클래스의 맴버로 인터페이스 선언
	interface OnClickListener {
		void onClick();
	}
}