package ch13;

public class GcExample {
	public static void main(String[] args) {
		Employee emp;
		emp = new Employee(1);
		emp = null;
		emp = new Employee(2);// 2번 객체 연결이 끊어짐
		emp = new Employee(3);// 3번 객체와 연결
		System.out.println("emp가 최종적으로 참조하는 사원 번호: \"" + emp.eno + "\"");
		System.gc();// 쓰레기 수집기 실행 요청 - 보통 떄 보다는 빠를 수 있을 걸.
		long time = System.nanoTime();
		System.out.println(time);
	}
}

class Employee {
	public int eno;

	public Employee(int eno) {
		this.eno = eno;
		System.out.println("Employee(" + eno + ") 이(가) 메모리에서 생성 됨");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Employee(" + eno + ") 이(가) 메모르에서 제거 됨");
	}

}