package ch22;

import java.util.Arrays;
import java.util.Random;

public class RandomMainExample2 {
	public static void main(String[] args) {
		int[] selectNumber = new int[6];
		Random random = new Random(3);
		System.out.println("선택 번호: ");
		for (int i = 0; i < selectNumber.length; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + "\t");
		}
		System.out.println();

		// 당첨 번호
		int[] wins = new int[6];
		random = new Random(3);
		System.out.println("당첨 번호: ");
		for (int i = 0; i < wins.length; i++) {
			wins[i] = random.nextInt(45) + 1;
			System.out.print(wins[i] + "\t");
		}
		System.out.println();
		// 당첨여부 확인
		Arrays.sort(selectNumber);
		Arrays.parallelSort(wins);
		System.out.println(Arrays.equals(selectNumber, wins));
	}
}