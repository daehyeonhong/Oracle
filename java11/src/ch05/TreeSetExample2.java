package ch05;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample2 {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();

		scores.add(97);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(new Integer(80));
		// 75 80 87 95 98

		// 역순 정렬된 set
		// 98 95 87 80 75
		System.out.println("내림차순 출력\t->");
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for (Integer score : descendingSet) {
			System.out.print(score + "\t");
		}
		System.out.println();

		System.out.println("기본 출력\t->");
		for (Integer score : scores) {
			System.out.print(score + "\t");
		}
		System.out.println();

		System.out.println("오름차순 출력\t->");
		NavigableSet<Integer> ascedingSet = descendingSet.descendingSet();
		for (Integer score : ascedingSet) {
			System.out.print(score + "\t");
		}
	}
}