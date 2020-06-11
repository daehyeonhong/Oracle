package ch04_01;

public class StudentExample {
	public static void main(String[] args) {
		Student student1 = new Student("홍길동", new int[] { 50, 60 });
		// 복제
		Student student2 = student1.getStudent();
		System.out.println("원본객체: " + student1);
		System.out.println("복제객체: " + student2);
		student2.scores[0] = 80;
		System.out.println("원본객체: " + student1);
		System.out.println("복제객체: " + student2);
	}
}