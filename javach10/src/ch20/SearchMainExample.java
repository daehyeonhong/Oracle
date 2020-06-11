package ch20;

import java.util.Arrays;

public class SearchMainExample {
	public static void main(String[] args) {
		// 기본타입
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
		System.out.println(index);
		System.out.println(scores[index]);

		// 문자열
		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println(index);
		System.out.println(names[index]);

		// 일반 객체
		Member[] members = { new Member("홍길동"), new Member("박동수"), new Member("김민수") };
		Arrays.sort(members);
		index = Arrays.binarySearch(members, new Member("홍길동"));
		System.out.println(members[index]);
	}
}