package ch04;

public class DaemonExample {
	public static void main(String[] args) {
		// Thread객체 생성
		AutoSaveThread autoSaveThread = new AutoSaveThread();

		// start()실행 전에 설정
		autoSaveThread.setDaemon(true);
		System.out.println("main_Thread 시작.");

		// 실행
		autoSaveThread.start();

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		System.out.print("main_Thread 종료.");
	}
}