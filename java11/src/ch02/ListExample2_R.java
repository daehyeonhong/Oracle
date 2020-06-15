package ch02;

import java.util.ArrayList;
import java.util.List;

public class ListExample2_R {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("일지매");
		list.add("임꺽정");
		list.add("일지매");
		list.add("이지매");
		list.add("임꺽정");

		// 저장된 객체 수 size
		System.out.println(list.size());

		// 삽입 add(index, 객체)
		list.add(1, "이순신");

		// 객체 얻기 get(index 번호) 0부터 시작
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("─────");

		for (String string : list) {
			System.out.println(string);
		}

		// 수정 set(index, 객체)
		list.set(2, "김길동");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 해당 객체가 list에 저장되어 있는지 확인 list.constains(object)
		System.out.println(list.size());
		System.out.println(list.contains("이순신") ? "list에 있습니다." : "list에 없습니다.");

		// 특정 index의 객체 삭제 remove (index)
		System.out.println(list.remove(3));

		// 특정 객체를 list에서 삭제 remove(객체) 삭제여부 return
		// 중복 저장된 객체는 모두 삭제
		System.out.println(list.remove("임꺽정"));
		System.out.println("─────");

		// 삭제 후 조회
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// list가 비어있는지 확인 isEmpty();
		System.out.println(list.isEmpty());

		// toArray() return_type Object[]
		Object[] strArray = list.toArray();

		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}

		for (Object obj : strArray) {
			System.out.println(obj);
		}

		// 전체 삭제 clear() 모든 요소 삭제
		list.clear();
		System.out.println("리스트 초기화 " + (list.isEmpty() ? "성공" : "실패"));
		System.out.println("─────");
	}
}