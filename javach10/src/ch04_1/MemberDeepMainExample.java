package ch04_1;

public class MemberDeepMainExample {
	public static void main(String[] args) {
		// 원본 객체
		Member original = new Member("홍길동", 25, new int[] { 90, 90 }, new Car("소나타"));
		// 복제 객체
		Member cloned = original.getMember();
		System.out.println("오리지날: " + original);
		System.out.println("클론: " + cloned);
		// 복제본 수정
		cloned.score[0] = 88;
		cloned.car = new Car("그랜져");
		// 원복 객체/ 복제 객체 출력
		System.out.println("오리지날: " + original);
		System.out.println("클론: " + cloned);
	}
}