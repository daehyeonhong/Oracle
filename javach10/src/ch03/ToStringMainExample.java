package ch03;

import java.util.Date;

public class ToStringMainExample {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString());// 날짜 정보 출력
		System.out.println(date);// 날짜 정보 출력,toString()자동 호출
		String str = new String("hello");
		System.out.println(str.toString());// 문자열 정보 출력 재정의 toString()
		System.out.println(str);
		Object obj = new Object();
		// getClass().getName() + "@" + Integer.toHexString(hashCode());
		System.out.println(obj.toString());
		System.out.println(obj);// 객체의 저장된 번지, 객체 생성 여부 확인
	}
}