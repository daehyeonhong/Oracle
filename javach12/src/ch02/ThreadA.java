package ch02;

public class ThreadA extends Thread {
	private WorkObject workObject;

	public ThreadA(WorkObject workObject) {
		this.workObject = workObject;// 공유객체 설정
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodA();// 공유객체의 methodA()를 10번 반복
		}
	}
}

class ThreadB extends Thread {
	private WorkObject workObject;

	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;// 공유객체 설정
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodB();// 공유객체의 methodB()를 10번 반복
		}
	}
}

class WorkObject {
	public synchronized void methodA() {
		notify();// 일시정지 상태의 ThreadB를 실행대기(RUNNABLE) 상태로 만듦
		System.out.println("ThreadA의 methodA()작업 실행");
		try {
			wait(); // ThreadA를 일시정지 상태로 만듦
			System.out.println("ThreadA의 methodA()작업 정지");
		} catch (Exception e) {
		}
	}

	public synchronized void methodB() {
		notify();// 일시정지 상태의 ThreadA를 실행대기 (RUNNABLE) 상태로 만듦
		System.out.println("ThreadB의 methodB()작업 실행");
		try {
			wait();// ThreadB를 일시정지 상태로 만듦
			System.out.println("ThreadB의 methodB()작업 정지");
		} catch (Exception e) {
		}
	}
}