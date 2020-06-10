package ch11;

import java.util.Comparator;
import java.util.Objects;

public class CompareMainExample {
	public static void main(String[] args) {
		Student s1 = new Student(1);
		Student s2 = new Student(1);
		Student s3 = new Student(2);

		int result = Objects.compare(s1, s2, new StudentComparator());
		System.out.println(result);

		result = Objects.compare(s1, s3, new StudentComparator());
		System.out.println(result);
	}
}

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.sno - o2.sno;
	}

	/*
	 * @Override public int compare(Student o1, Student o2) { return o1.sno < o2.sno
	 * ? -1 : o1.sno == o2.sno ? 0 : 1; }
	 */
	/*
	 * @Override public int compare(Student o1, Student o2) { // TODO Auto-generated
	 * method stub return 0; }
	 */
	/*
	 * @Override public int compare(Student o1, Student o2) { if (o1.sno < o2.sno) {
	 * return -1; } else if (o1.sno == o2.sno) { return 0; } else { return 1; } }
	 */
}

class Student {
	int sno;

	public Student(int sno) {
		this.sno = sno;
	}
}