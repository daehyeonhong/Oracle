package ch06;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample2 {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<Integer, String>();

		scores.put(87, "홍길동");
		scores.put(new Integer(98), "이동수");
		scores.put(75, "일지매");
		scores.put(95, "신용권");
		scores.put(80, "김길동");

		NavigableMap<Integer, String> descMap = scores.descendingMap();

		Set<Map.Entry<Integer, String>> descEntrySet = descMap.entrySet();
		for (Map.Entry<Integer, String> string : descEntrySet) {
			System.out.print(string + ", ");
		}
	}
}