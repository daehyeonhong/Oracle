package ch04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample1 {
	public static void main(String[] args) {
		// Map<키, 값>
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("apple", "사과");
		dictionary.put("pear", "배");
		dictionary.put("grape", "포도");
		dictionary.put("mango", "망고");

		System.out.print("원하는 영어 단어를 입력하세요> ");
		try (Scanner scanner = new Scanner(System.in)) {
			String key = scanner.next();
			System.out.println(key + "의 한글 뜻: " + dictionary.get(key));
		} catch (Exception e) {
			e.getMessage();
		}
	}
}