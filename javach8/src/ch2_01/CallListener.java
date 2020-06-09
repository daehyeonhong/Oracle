package ch2_01;

//implements 바깥 쪽 클래스.내부 인터페이스
public class CallListener implements Button.OnClickListener {
	@Override
	public void onClick() {
		System.out.println("전화를 겁니다.");
	}
}