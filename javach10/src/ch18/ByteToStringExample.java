package ch18;

public class ByteToStringExample {
	public static void main(String[] args) {
		// byte 배열로 String()객체의 매개변수로 넘겨서 문자열 생성
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		// byte 배열 전체
		String str1 = new String(bytes);
		System.out.println(str1);
		// byte 배열 일부,String(배열,시작offset,갯수)
		String str2 = new String(bytes, 6, 4);// index번호 6, 갯수 4
		System.out.println(str2);
	}
}