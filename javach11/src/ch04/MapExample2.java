package ch04;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapExample2 {
	public static void main(String[] args) {
		Map<String, Integer> cities = new HashMap<String, Integer>();
		cities.put("seoul", new Integer(25));
		cities.put("beijing", new Integer(999999));
		cities.put("tokyo", new Integer(999999));// 값이 중복 저장
		cities.put("pyungyang", new Integer(999999));// 값이 중복 저장
		cities.put("pyungyang", new Integer(999999));// 키가 중복-Map에 중복된 key는 저장 불가

		// key들만 SET에 저장하는 메소드
		Set<String> keys = cities.keySet();
		System.out.println(keys);

		// key들만 뽑아서 출력
		Iterator<String> itor = keys.iterator();

		// key를 이용하여 map에서 값 가져오기
		itor = keys.iterator();
		while (itor.hasNext()) {
			String city = itor.next();
			DecimalFormat df = new DecimalFormat("#,###℃");
			System.out.println(city + "의 온도는 " + df.format(cities.get(city)) + "입니다.");
		}

		while (itor.hasNext()) {
			System.out.println(itor.next());
		}
		System.out.print("현재 기온을 알고 싶은 도시명을 입력하세요> ");
		try (Scanner scanner = new Scanner(System.in)) {
			String city = scanner.next();
			DecimalFormat df = new DecimalFormat("#,###℃");
			System.out.println(city + "의 현재 온도: " + df.format(cities.get(city)) + "입니다.");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}