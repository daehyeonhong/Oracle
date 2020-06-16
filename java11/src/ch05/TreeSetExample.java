package ch05;

import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		// TreeSet객체 생성
		TreeSet<Integer> scores = new TreeSet<Integer>();

		scores.add(new Integer(87));
		scores.add(98);
		scores.add(new Integer(75));
		scores.add(95);
		scores.add(80);

		System.out.println("가장 낮은 점수: " + scores.first());
		System.out.println("가장 높은 점수: " + scores.last());

		System.out.println("95점 아래 점수: " + scores.lower(95));
		System.out.println("95점 윗 점수: " + scores.higher(new Integer(95)));

		System.out.println("95점 이거나 바로 아래 점수: " + scores.floor(95));
		System.out.println("94점 이거나 바로 아래 점수: " + scores.floor(94));

		System.out.println("85점 이거나 바로 윗 점수: " + scores.ceiling(85));
		System.out.println("87점 이거나 바로 윗 점수: " + scores.ceiling(87));

		// while (!scores.isEmpty()) {
		// Integer score = scores.pollFirst();// 작은 것부터 출력
		// System.out.println(score + "남은 객체 수: " + scores.size());
		// }

		while (!scores.isEmpty()) {
			Integer score = scores.pollLast();// 큰 것부터 출력
			System.out.println(score + "남은 객체 수: " + scores.size());
		}
	}
}