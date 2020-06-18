package ch06;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapExample3 {
	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 10);
		treeMap.put("base", 20);
		treeMap.put("guess", 700);
		treeMap.put("cherry", 30);

		System.out.println("[c~f]사이의 값 검색");
		NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "f", true);

		// Map.entrySet() Map.Entry<k,V>
		for (Map.Entry<String, Integer> c : rangeMap.entrySet()) {
			System.out.println(c.getKey() + "=" + c.getValue());
		}
	}
}