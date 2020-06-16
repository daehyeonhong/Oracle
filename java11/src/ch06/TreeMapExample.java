package ch06;

import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();

		scores.put(new Integer(87), "홍길동");
		scores.put(new Integer(98), "일지매");
		scores.put(new Integer(75), "임꺽정");
		scores.put(new Integer(95), "이순신");
		scores.put(new Integer(80), "김유신");

		System.out.println("처음:\t" + scores.firstEntry().getKey() + "=" + scores.firstEntry().getValue());
		System.out.println("마지막:\t" + scores.lastEntry().getKey() + "=" + scores.lastEntry().getValue());

		System.out.println(scores.lowerEntry(95).getKey() + "=" + scores.lowerEntry(95).getValue());
		System.out.println(scores.higherEntry(95).getKey() + "=" + scores.higherEntry(95).getValue());

		System.out.println("95거나 95보다 큰 값\t" + scores.floorEntry(95).getKey() + "=" + scores.floorEntry(95).getValue());
		System.out.println(
				"95거나 95보다 작은 값\t" + scores.ceilingEntry(95).getKey() + "=" + scores.ceilingEntry(95).getValue());
	}
}