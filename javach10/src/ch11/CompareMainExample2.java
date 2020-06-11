package ch11;

import java.util.Comparator;
import java.util.Objects;

public class CompareMainExample2 {
	public static void main(String[] args) {
		System.out.println(Objects.compare(new Member("홍길동"), new Member("일지매"), new MemberCompare()));
	}
}

class Member {
	String name;

	public Member(String name) {
		this.name = name;
	}

}

// 순서비교, 첫번째 객체와 두번째 객채의 순서 비교->값이 음수면 첫번째가 먼저, 양수면 첫번째가 나중, 0이면 같은 순서
class MemberCompare implements Comparator<Member> {

	@Override
	public int compare(Member o1, Member o2) {
		return o1.name.hashCode() - o2.name.hashCode();
	}

}