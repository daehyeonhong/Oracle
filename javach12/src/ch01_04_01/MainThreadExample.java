package ch01_04_01;

public class MainThreadExample {
	public static void main(String[] args) {
		// 공유 객체
		Calculator calculator = new Calculator();

		User1 user1 = new User1();
		System.out.println("user1.getState: " + user1.getState());
		user1.setCalculator(calculator);
		System.out.println("user1.getState: " + user1.getState());
		user1.start();// 실행 요청
		System.out.println("user1.getState: " + user1.getState());

		User2 user2 = new User2();
		System.out.println("user2.getState: " + user2.getState());
		System.out.println("user1.getState: " + user1.getState());
		user2.setCalculator(calculator);
		System.out.println("user2.getState: " + user2.getState());
		System.out.println("user1.getState: " + user1.getState());
		user2.start();// 실행 요청
		System.out.println("user2.getState: " + user2.getState());
	}
}