package ch02_03;

import java.util.Vector;

public class VectorMainExample5 {
	public static void main(String[] args) {
		VectorTest vt = new VectorTest();

		// 백터객체 생성
		Vector<Integer> v = new Vector<>();

		// 값 저장
		v.add(10);
		v.add(20);
		v.add(30);

		// method의 매개변수로 전달
		vt.printVector(v);
	}
}

class VectorTest {
	// method의 매개변수가 콜렉션인 경우
	public void printVector(Vector<Integer> v) {
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}
}