package ch01_05;

public class TargetThread extends Thread {
	@Override
	public void run() {
		for (long i = 0; i < 10000000; i++) {
		}

		try {
			Thread.sleep(1500);// 1.5초간 멈춤
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (long j = 0; j < 100000000; j++) {
		}
	}
}