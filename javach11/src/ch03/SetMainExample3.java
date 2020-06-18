package ch03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetMainExample3 {
	public static void main(String[] args) {
		// 로또 프로그램
		Random random = new Random();
		Set<Integer> lotto = new HashSet<Integer>();

		int count = 0;
		while (lotto.size() < 6) {
			lotto.add(random.nextInt(45) + 1);// 1부터 45까지 무작위 정수
			count++;
			System.out.print(count + "번\t");
		}// 죽복되지않는 값 저장

		Iterator<Integer> itor = lotto.iterator();// set의 객체를 하나씩 처리하는 객체iterator

		System.out.println();
		while (itor.hasNext()) {
			System.out.print(itor.next() + ", ");
		}

		System.out.println();
		
		lotto.clear();
		while (lotto.size() < 6) {// 객체가 저장되는 갯수
			int ran = (int) (Math.random() * 45) + 1;
			lotto.add(ran);
			System.out.print(ran + ", ");
		}

		System.out.println();
		while (itor.hasNext()) {
			System.out.print(itor.next() + ", ");
		}
	}
}