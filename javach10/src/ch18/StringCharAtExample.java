package ch18;

public class StringCharAtExample {
	public static void main(String[] args) {
		char c = "홍길동".charAt(0);
		System.out.println(c);
		for (int i = 0; i < "홍길동".length(); i++) {
			System.out.println("홍길동".charAt(i));
		}
		String ssn = "010624-1230123";
		int pos = ssn.indexOf("-");
		char gender = ssn.charAt(pos + 1);
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남");
			break;
		case '2':
		case '4':
			System.out.println("여");
			break;
		default:
			break;
		}
	}
}