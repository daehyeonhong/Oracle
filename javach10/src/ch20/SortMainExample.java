package ch20;

import java.util.Arrays;

public class SortMainExample {
	public static void main(String[] args) {

		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);// 기본 타입의 값 배열 정렬
		System.out.println(Arrays.toString(scores));

		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);// String type의 값 배열 정렬
		System.out.println(Arrays.toString(names));

		// cannot be cast to java.lang.Comparable
		Member[] members = { new Member("홍길동"), new Member("박동수"), new Member("김민수") };
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
	}
}