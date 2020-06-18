package ch09;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsExample {
	static void printList(LinkedList<String> list) {
		Iterator<String> itor = list.iterator();
		while (itor.hasNext()) {
			String e = itor.next();
			String separtor;
			separtor = (itor.hasNext() ? "->" : "\n");
			System.out.print(e + separtor);
		}
	}

	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add(0, "터미네이터");// 중간 삽입
		myList.add(2, "아바타");// 중간 삽입

		int selectIndex = 3;
		printList(myList);
		System.out.println(selectIndex + 1 + "번째 항목은 " + myList.get(selectIndex) + "입니다.\n");
		Collections.sort(myList);// 오름차순 정렬
		printList(myList);
		System.out.println(selectIndex + 1 + "번째 항목은 " + myList.get(selectIndex) + "입니다.\n");
		Collections.reverse(myList);// 내림차순 정렬
		printList(myList);
		System.out.println(selectIndex + 1 + "번째 항목은 " + myList.get(selectIndex) + "입니다.\n");

		int index = Collections.binarySearch(myList, "아바타");
		System.out.println("아바타는 " + (index + 1) + "번째 요소입니다.");
	}
}