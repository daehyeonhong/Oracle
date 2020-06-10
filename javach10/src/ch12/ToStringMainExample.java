package ch12;

import java.util.Objects;

public class ToStringMainExample {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = null;
		System.out.println(Objects.toString(str1));// 문자값
		System.out.println(Objects.toString(str2));// null
		System.out.println(Objects.toString(str2, "이름이 없습니다."));// null이면 대체 문자 출력
	}
}