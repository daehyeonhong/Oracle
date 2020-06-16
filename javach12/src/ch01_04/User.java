package ch01_04;

public class User extends Thread {
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("user1");
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(100);
	}
}