package ch25;

import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		System.out.println(now.getDate());

		// java.util package Date의 long형 값을 이용하여 생성
		java.sql.Date now2 = new java.sql.Date(now.getTime());
		System.out.println(now2);
	}
}