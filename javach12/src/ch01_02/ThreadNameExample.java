package ch01_02;

public class ThreadNameExample {
	public static void main(String[] args) {
		// 실행중 thread 정보 얻기 currentThread()
		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램 시작 쓰레드 명: " + mainThread.getName());

		ThreadA a = new ThreadA();
		System.out.println("작업 쓰레드 이름: " + a.getName());
		a.start();

		// 이름 없이 생성 Thread-1, Thread-2,...로 이름 부여.
		ThreadB b = new ThreadB();
		System.out.println("작업 쓰레드 이름: " + b.getName());
		b.start();

		b = new ThreadB();
		System.out.println("작업 쓰레드 이름: " + b.getName());
		b.start();

		b = new ThreadB();
		System.out.println("작업 쓰레드 이름: " + b.getName());
		b.start();

		a = new ThreadA();
		System.out.println("작업 쓰레드 이름: " + a.getName());
		a.start();
	}
}

class ThreadA extends Thread {
	public ThreadA() {
		setName("ThreadA");
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
	}
}

class ThreadB extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
	}
}