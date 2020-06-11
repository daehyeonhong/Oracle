package ch18;

public class StringToByteExample {
	public static void main(String[] args) {
		String str = "안녕하세요";

		byte[] bytes1 = str.getBytes();
		System.out.println(bytes1.length);// 한 단어당 3바이트씩 구성
		System.out.println(new String(bytes1));
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");// 문자열을 2바이트씩 잘라서 배열로 생성
			System.out.println(bytes2.length);
			System.out.println(new String(bytes2));

			byte[] bytes3 = str.getBytes("UTF-8");// 문자열을 3바이트씩 잘라서 배열로 생성
			System.out.println(bytes3.length);
			System.out.println(new String(bytes3));
		} catch (Exception e) {
		}
	}
}