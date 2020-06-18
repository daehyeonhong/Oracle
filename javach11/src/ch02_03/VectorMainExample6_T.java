package ch02_03;

import java.util.Vector;

public class VectorMainExample6_T {
	public static void main(String[] args) {
		BoardTest_T bt = new BoardTest_T();

		// 백터객체 생성
		Vector<Board> v = new Vector<>();

		// 값 저장
		v.add(new Board("제목1", "내용1", "글쓴이1"));
		v.add(new Board("제목2", "내용2", "글쓴이2"));
		v.add(new Board("제목3", "내용3", "글쓴이3"));

		// method의 매개변수로 전달
		bt.printBoard(v);
	}
}

class BoardTest_T {
	// method의 매개변수가 콜렉션인 경우
	public void printBoard(Vector<Board> v) {// [Board][Board][Board]
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}
}