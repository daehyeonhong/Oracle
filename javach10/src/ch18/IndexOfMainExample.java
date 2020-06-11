package ch18;

public class IndexOfMainExample {
	public static void main(String[] args) {
		String str = "hi hi hi i am a boy";
		int index = str.indexOf("hi");// 처음부터 "hi"패턴 찾음
		System.out.println(index);
		index = str.indexOf("h", 5);// index번호가 5번 이후부터 찾음
		System.out.println(index);
		index = str.lastIndexOf("hi");// 마지막에 나타나는 "hi"의 시작번호
		System.out.println(index);

		System.out.println(str.length());// 문자열의 길이
		System.out.println("hi hi hi i am a boy".length());// 문자열의 길이

		// 문자열 대치(old문자,new문자)
		String str2 = str.replace("hi", "hello");
		System.out.println(str);
		System.out.println(str2);

		String ssn = "880815-1234567";
		System.out.println(ssn.substring(0, ssn.indexOf("-")));
		System.out.println(ssn.substring(ssn.indexOf("-") + 1));
		System.out.println(ssn.indexOf("9") > -1 ? "9가 문자열 내에 존재합니다" : "9가 문자열 내에 없습니다.");

		String prg = "Java Programming";
		System.out.println(prg);
		System.out.println(prg.toUpperCase());
		System.out.println(prg.toLowerCase());

		prg = "					Java Programming					";
		System.out.println(prg.length());
		System.out.println(prg.trim().length());
		System.out.println(prg.trim());
		System.out.println(prg.equals(prg.trim()));
	}
}