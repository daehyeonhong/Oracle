package ch02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample_R {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();

		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list1.add(0, String.valueOf(i));
		}
		long endTime = System.nanoTime();
		System.out.println("list1의 소요 시간: " + (endTime - startTime));
		System.out.println("─────────────");

		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("list2의 소요 시간: " + (endTime - startTime));
		System.out.println("─────────────");

		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list1.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("list1의 소요 시간: " + (endTime - startTime));
		System.out.println("─────────────");

		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list2.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("list2의 소요 시간: " + (endTime - startTime));
	}
}