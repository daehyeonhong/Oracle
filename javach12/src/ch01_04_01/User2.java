package ch01_04_01;

public class User2 extends Thread {
	// 공유 객체
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("User1");// Set_Thread_name
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
