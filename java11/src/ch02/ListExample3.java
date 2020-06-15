package ch02;

import java.util.ArrayList;
import java.util.List;

public class ListExample3 {
	public static void main(String[] args) {
		// "사과", "배", "포도" 과일을 저장하는 리스트 생성 후 저장하고, 내용 출력
		List<String> list = new ArrayList<String>();

		list.add("사과");
		list.add("배");
		list.add("포도");

		for (String string : list) {
			System.out.println(string);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}