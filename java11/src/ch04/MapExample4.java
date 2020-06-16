package ch04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample4 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Map<String, String> dic1 = new HashMap<String, String>();
			boolean isRun = true;

			while (isRun) {
				System.out.print("단어를 입력하세요> ");
				String key = scanner.next();

				System.out.print("설명을 입력하세요> ");
				String value = scanner.next();

				// map에 key와 value를 저장
				dic1.put(key, value);

				System.out.print("계속할까요?[Y/N]");
				char yesNo = scanner.next().charAt(0);
				isRun = (yesNo == 'N' || yesNo == 'n') ? false : true;
			}

			System.out.print("설명을 보려는 단어를 입력하세요> ");
			String word = scanner.next();
			System.out.println(dic1.get(word));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}