package ch13;

public class ExitMainExample2 {
	public static void main(String[] args) {
		int count = 0;
		while (true) {
			System.out.println(count + "hello");
			count++;
			if (count == 10) {
				System.out.println("프로그램 종료!");
				System.exit(0);
			}
		}
		// System.out.println("프로그램 종료!");
	}
}