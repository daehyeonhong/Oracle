package ch04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample5 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		// 객체 저장
		map.put("홍길동", 95);
		map.put("일지매", 90);
		map.put("임꺽정", 80);
		map.put("이소룡", 95);

		// 총 저장된 Entry 수
		System.out.println("총 Entry 수: " + map.size());

		// 객체 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();

		while (entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println("key: " + key + "\tvalue: " + value);
		}

		for (Map.Entry<String, Integer> s : entrySet) {
			System.out.println(s.getKey() + "=" + s.getValue());
		}

		// map 내용 삭제
		map.clear();

		// map 상태 조회
		System.out.println("map이 " + (map.isEmpty() ? "비어있습니다." : "값이 있습니다."));
	}
}