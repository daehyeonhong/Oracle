package ch02_03;

import java.util.Arrays;
import java.util.List;

public class VectorMainExample2 {
	public static void main(String[] args) {
		// Arrays.asList();
		List<String> list1 = (List<String>) Arrays.asList("홍길동", "일지매", "임꺽정");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}

		// Arrays.asList();
		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
	}
}