package ch04;

public class MemberMainExample {
	public static void main(String[] args) {
		// 원본 객체 생성
		Member original = new Member("hong", "홍길동", "1234", 20, true);
		// 복제 객체 생성
		Member cloned = original.getMember();
		// 원본 객체 출력
		System.out.println(original);
		// 복제 객체 출력
		System.out.println(cloned);

		// 복제 객체 수정
		cloned.id = "kim";
		cloned.name = "김길동";
		cloned.password = "3333";
		cloned.age = 13;
		cloned.adult = false;
		// 출력
		System.out.println(original);
		System.out.println(cloned);
	}
}