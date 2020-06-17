package ch01_01_01;

import java.awt.Toolkit;

public class ThreadExample {
	public static void main(String[] args) {
		// Thread class 생성 실행
		// Thread class를 상속받은 자식 클래스 생성 new 클래스명()
		SoundThread soundThread = new SoundThread("soundThread");
		System.out.println(soundThread.getPriority());// thread 우선 순위 표시

		// 생성시는 priority = 5, MIN_PRIORITY = 1, MAX_PRIORITY = 10
		soundThread.setPriority(Thread.MIN_PRIORITY);// 1~10
		System.out.println(soundThread.getName());
		soundThread.start();// 실행 -> 실행요청(JVM)
		// soundThread.run();//Thread 실행이 아님

		Thread th = Thread.currentThread();
		System.out.println(th.getName());

		// Runnable interface로 구현한 class로 Thread생성
		// -> new Thread(new 구현클래스());
		Thread printThread = new Thread(new PrintThread());
		System.out.println(printThread.getName());
		printThread.start();// 실행 요청(JVM)
		// printThread.run();//Thread 실행이 아님
	}
}

//Thread_class 상속
class SoundThread extends Thread {
	Toolkit toolkit = Toolkit.getDefaultToolkit();

	public SoundThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);// 500밀리 초 = 0.5초 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PrintThread implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);// 500밀리 초 = 0.5초 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}