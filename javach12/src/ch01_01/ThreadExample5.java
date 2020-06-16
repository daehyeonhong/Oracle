package ch01_01;

public class ThreadExample5 {
	public static void main(String[] args) {
		Thread thread = new Thread(new Child());
		thread.start();// JVM에게 실행을 요청->스케쥴에 따라 Run_method를 실행
		thread.run();// Main에서 thread의 run_method를 직접 호출
	}
}

class Parent {

}

class Child extends Parent implements Runnable {// 상속과 확장 동시에 가능
	int sum;

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			sum += i;
			System.out.print(sum + "\t|" + ((i % 5 == 0) ? "\n" : ""));
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}