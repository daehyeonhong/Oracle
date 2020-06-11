package ch21;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingUBoxingExample {
	public static void main(String[] args) {
		// AutoBoxing
		Integer obj = 100;// 래퍼 변수 = 기본 type 값
		System.out.println("value: " + obj.intValue());

		// AutoUnboxing
		int result = obj;// 기본타입 변수 = 래퍼;
		System.out.println("value: " + result);

		// 리스트 자료 저장 객체
		// interface
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(100));// wrapper
		list.add(new Integer("200"));// wrapper
		list.add(300);// 기본 타입 값 -> autoBoxing해서 Wrapper type으로 변신 저장

		for (int i = 0; i < list.size(); i++) {// Integer(100),Integer(200),Integer(300)
			System.out.println(list.get(i));
		} // 100,200,300 -> autoUnBoxing

		for (Integer integer : list) {
			System.out.println(integer);
		}

	}
}