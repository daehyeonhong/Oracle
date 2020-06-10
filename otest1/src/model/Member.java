package model;

public class Member {
	private int mno;
	private String name;
	private String password;
	private String address;

	public Member() {
	}

	public Member(int mno, String name, String password, String address) {
		this.mno = mno;
		this.name = name;
		this.password = password;
		this.address = address;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + ", name=" + name + ", password=" + password + ", address=" + address + "]";
	}
}