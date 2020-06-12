package ch26;

import java.text.MessageFormat;

public class MessageFormatExample {
	public static void main(String[] args) {
		String id = "java";
		String name = "홍길동";
		String tel = "010-1234-5678";

		String text = "회원ID: {0}\n회원 이름: {1}\n회원 전화: {2}";
		String result = MessageFormat.format(text, id, name, tel);
		System.out.println(result);

		String sql = "INSERT INTO MEMBER VALUES({0},{1},{2})";
		Object[] arguments = { "'hong'", "'홍길동'", "'1234'" };
		String result2 = MessageFormat.format(sql, arguments);
		System.out.println(result2);
	}
}