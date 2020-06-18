package ch02_02;

import java.util.ArrayList;
import java.util.List;

public class ListExample1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(10);// AutoBoxing
		list.add(new Integer(20));// constructor
		list.add(Integer.valueOf(30));// valueOf()method

		// 저장된 갯수
		System.out.println("저장된 갯수: " + list.size());

		// 삽입
		list.add(1, 55);

		// 수정
		list.set(2, 99);

		// 중복 저장
		list.add(10);

		// 출력 get()
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 삭제 remove(index)
		list.remove(0);

		// 삭제 remove(object)
		// 숫자 remove(숫자) <- index로 인식 remove(new Integer(숫자))
		list.remove(new Integer(55));

		// 저장되어있는지 여부 확인 contains
		System.out.println(list.contains(99));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		//
		System.out.println("삭제 전\n-> " + list.isEmpty());

		// 전체 삭제
		list.clear();
		System.out.println("삭제 후\n-> " + list.isEmpty());
	}
}