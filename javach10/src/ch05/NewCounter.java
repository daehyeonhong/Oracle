package ch05;

public class NewCounter {
	int no;

	public NewCounter(int no) {
		this.no = no;
	}

	// Garbage collector가 객체 소멸시 실행되는 메소드
	@Override
	protected void finalize() throws Throwable {
		System.out.println(no + " 삭제");
	}
}