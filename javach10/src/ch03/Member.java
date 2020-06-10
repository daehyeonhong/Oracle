package ch03;

public class Member {
	int memberNo;
	String name;
	String password;
	String address;
	String tel;

	public Member(int memberNo, String name, String password, String address, String tel) {
		this.memberNo = memberNo;
		this.name = name;
		this.password = password;
		this.address = address;
		this.tel = tel;
	}

	// 사용자 정의 객체의 필드 값 출력
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", name=" + name + ", address=" + address + ", tel=" + tel + "]";
	}
}