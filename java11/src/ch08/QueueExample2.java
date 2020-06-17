package ch08;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample2 {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<String>();

		que.offer("hello");
		que.offer("hi");
		que.offer("greeting");

		System.out.println(que.peek());// 가장 먼저 저장된 객체
		System.out.println(que.poll());// 가장 먼저 저장된 객체 보여주고 삭제하기
		System.out.println(que.peek());
	}
}