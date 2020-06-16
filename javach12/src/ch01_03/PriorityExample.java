package ch01_03;

public class PriorityExample {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			Thread thread = new CalcThread("thread" + i);
			System.out.println("'thread" + i + "'의 생성시 우선 순위: " + thread.getPriority());
			if (i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);// 1
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);// 10
			}
			thread.start();// 실행 요청
			// thread.run();
		}
	}
}

class CalcThread extends Thread {
	public CalcThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 200000000; i++) {
		}
		System.out.println(getName());
	}
}