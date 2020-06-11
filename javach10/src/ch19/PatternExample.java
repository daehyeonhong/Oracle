package ch19;

import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result ? "정규식과 일치합니다." : "정규식과 일치하지 않습니다.");

		// regExp = "\\w+@\\w+\\.\\w+(\\w+)";
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)";
		data = "angel@naver.com";
		System.out.println(Pattern.matches(regExp, data) ? "형식에 맞는 이메일 주소입니다." : "형식에 맞지 않는 이메일 주소입니다.");// "형식에 맞는 이메일
																											// 주소입니다.//형식에
																											// 맞지 않는 이메일
																											// 주소입니다.

		data = "angel@naver.co.kr";
		System.out.println(Pattern.matches(regExp, data) ? "형식에 맞는 이메일 주소입니다." : "형식에 맞지 않는 이메일 주소입니다.");// "형식에 맞는 이메일
																											// 주소입니다.//형식에
																											// 맞지 않는 이메일
																											// 주소입니다.
	}
}