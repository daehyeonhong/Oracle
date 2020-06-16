package ch01_04;

public class MainThreadExample {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		User user1 = new User();
		user1.setCalculator(calculator);
		user1.start();

		User user2 = new User();
		user2.setCalculator(calculator);
		user2.start();

	}
}