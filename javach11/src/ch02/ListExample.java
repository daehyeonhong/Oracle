package ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {
		// List인터페이스 변수=new ArrayList();
		List<String> strList = new ArrayList<String>();

		// 요소 추가 add(요소)
		strList.add("배");
		strList.add("사과");
		strList.add("포도");
		strList.add("사과");// 요소 중복 저장 가능(index번호로 요소 관리)

		// 저장된 요소 갯수 size()
		System.out.println(strList.size());

		// 리스트 출력
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));// 얻기 get(index번호)
		}

		System.out.println("───");

		for (String s : strList) {
			System.out.println(s);
		}
		// 삽입 add(index, 요소)
		strList.add(2, "망고");

		// 리스트 출력
		System.out.println(strList.size());
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));// 얻기 get(index번호)
		}

		System.out.println("───");

		for (String list : strList) {
			System.out.println(list);
		}

		// 배열로 리턴
		Object[] objs = strList.toArray();
		System.out.println("ooooooooooooooooo");
		System.out.println(Arrays.toString(objs));

		// Vector v;
		// 특정위치 요소 출력 ArrayList에는 elementAt(index)없음.
		// ((ArrayList<String>)strList).elementData("사과");

		// 리스트 내의 요소 수정 set(index번호, 요소)
		strList.set(2, "바나나");

		// 삽입
		// IndexOutOfBoundsException 범위를 벗어난 삽입 불가
		// strList.add(7, "바나나");
		// System.out.println(strList.size());// 5

		System.out.println(strList.contains("망고") ? "리스트에 망고가 저장되어있습니다." : "리스트에 망고가 저장되어있지 않습니다.");

		// indexOf(요소)
		System.out.println("망고가 저장된 index 번호: " + strList.indexOf("망고"));
		// list에 저장되어있지 않은 요소인 경우 indexOf(요소) 리턴값은 -1
		System.out.println("멜론이 저장된 index 번호: " + strList.indexOf("멜론"));

		// 삭제 remove(index)
		strList.remove(2);
		System.out.println(strList.size());
		for (String s : strList) {
			System.out.println(s);
		}

		// 비어있는지 여부 확인 isEmpty()
		System.out.println(strList.isEmpty() ? "비어있습니다." : "요소가 남아있습니다.");

		// 모두 삭제 clear()
		System.out.println(strList.size());
		strList.clear();
		System.out.println(strList.size());
		System.out.println(strList.isEmpty() ? "비어있습니다." : "요소가 남아있습니다.");

	}
}