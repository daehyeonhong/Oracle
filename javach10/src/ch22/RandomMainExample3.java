package ch22;

import java.util.Random;

public class RandomMainExample3 {
	public static void main(String[] args) {
		// 두개의 주사위 합 6이 되면 종료
		Random dice2 = new Random();
		Random dice1 = new Random();
		while (true) {
			int result1 = dice1.nextInt(6) + 1;
			int result2 = dice2.nextInt(6) + 1;
			System.out.print("첫번째 주사위: " + result1 + ',');
			System.out.println("두번째 주사위: " + result2);
			if (result1 + result2 == 6) {
				break;
			}
		}
	}
}