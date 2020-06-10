package ch01;

public class ObjectMainExample {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		// 번지비교 연산자 ==
		System.out.println(obj1 == obj2);
		// 번지비교 .equals()
		System.out.println(obj1.equals(obj2));

		String s = "홍길동";
		String s1 = "홍길동";
		String s2 = new String("홍길동");

	}

	public boolean equals(Object anObject) {
		char[] value = {};
		// 번지 값 비교 번지 값이 같으면 같은 객체
		if (this == anObject) {
			return true;
		}
		// 번지 값이 다른 경우
		if (anObject instanceof String) {// 2.같은 String type인지 비교
			// String type이면
			// String anotherString = (String) anObject;
			int n = value.length;
			// String 객체에 저장된 내용 비교 //3.전체 내용이 똑같다면 true 동등한 객체
			// if (n == anotherString.length()) {
			// char v1[] = value;
			// char v2[] = anotherString;
			// int i = 0;
			// while (n-- != 0) {
			// if (v1[i] != v2[i])
			// return false;
			// i++;
			// }
			// return true;
			// }
		}
		return false;
	}
}