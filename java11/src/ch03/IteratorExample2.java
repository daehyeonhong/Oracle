package ch03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample2 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 20, 30, 40);
		Iterator<Integer> itor = list.iterator();

		int sum = 0;

		while (itor.hasNext()) {
			sum += itor.next();
		}

		System.out.println(sum);
	}
}