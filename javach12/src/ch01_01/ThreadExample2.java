package ch01_01;

import java.awt.Toolkit;

public class ThreadExample2 {
	public static void main(String[] args) {
		WorkerThread workerThread = new WorkerThread();
		workerThread.start();
	}
}

//Thread class를 상속받아서 생성
class WorkerThread extends Thread {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}