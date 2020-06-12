package ch20;

import java.util.Arrays;

public class SortMainExample2 {
	public static void main(String[] args) {
		int[] arr1 = { 99, 87, 77 };
		String[] arr2 = { "홍길동", "일지매", "임꺽정" };
		Student[] students = { new Student(3), new Student(1), new Student(2) };

		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));

		Arrays.sort(arr2);
		System.out.println(arr2);

		Arrays.sort(students);
		System.out.println(students);

		System.out.println(Arrays.toString(students));
	}

}

class Student implements Comparable<Student> {
	int sno;

	public Student(int sno) {
		this.sno = sno;
	}

	@Override
	public int compareTo(Student o) {
		return sno - o.sno;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + "]";
	}
}