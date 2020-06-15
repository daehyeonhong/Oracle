package ch02;

import java.util.ArrayList;
import java.util.List;

public class ListExample4 {
	public static void main(String[] args) {
		// 100, 350, 500 세 숫자를 저장하는 리스트 생성 후 저장하고 출력
		List<Integer> list = new ArrayList<Integer>();

		list.add(100);// int -> Integer AutoBoxing
		list.add(350);
		list.add(500);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));// Integer -> int AutoUnBoxing
		}

		for (Integer integer : list) {
			System.out.println(integer);// Integer -> int AutoUnBoxing
		}
	}
}