package ch22;

import java.util.Random;

public class RandomMainExample {
	public static void main(String[] args) {
		int[] selectNumber = new int[6];
		Random random = new Random();
		for (int i = 0; i < selectNumber.length; i++) {
			selectNumber[i] = random.nextInt(45);
		}
		for (int i = 0; i < selectNumber.length; i++) {
			System.out.println(selectNumber[i]);
		}
	}
}