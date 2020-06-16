package ch01_01;

public class ThreadExample3 {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.run();
	}
}

//Thread class를 상속 받아서
//SumThread class를 생성
//1~100까지의 값 sum
class SumThread extends Thread {
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