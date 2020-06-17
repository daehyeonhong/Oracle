package ch03;

public class InterruptExample {
	public static void main(String[] args) {
		Thread thread = new PrintThead();
		thread.start();// 실행 요청
		try {
			Thread.sleep(1000);// 1초
		} catch (Exception e) {
		}
		thread.interrupt();// interrupt예외 발생
	}
}

class PrintThead extends Thread {
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("실행 중");
				Thread.sleep(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}