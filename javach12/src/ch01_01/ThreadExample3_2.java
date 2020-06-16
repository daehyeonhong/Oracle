package ch01_01;

public class ThreadExample3_2 {
	public static void main(String[] args) {
		Thread thread = new Thread(new SumThread2());// 생성자의 매개변수 Runnable로 Promotion
		thread.start();
	}
}

//Thread class를 상속 받아서
//SumThread class를 생성
//1~100까지의 값 sum
class SumThread2 implements Runnable {
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