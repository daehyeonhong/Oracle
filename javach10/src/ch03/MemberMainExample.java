package ch03;

public class MemberMainExample {
	public static void main(String[] args) {
		Member member = new Member(1, "홍길동", "1234", "서울시", "010-111-1234");
		System.out.println(member.toString());// 정보 출력용
		System.out.println(member);
		System.out.println(((Object)member).toString());
	}
}