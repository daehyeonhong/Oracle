package ch01_01;

public class BeepPrintExample {
	public static void main(String[] args) {
		// 인터페이스 변수 = new 구현클래스()
		Runnable beepTask = new BeepTask();

		// Thread 클래스 생성자의 매개변수로 Runnable 인터페이스 전달
		Thread thread = new Thread(beepTask);

		// thread실행 요청(JVM)
		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("삡");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}