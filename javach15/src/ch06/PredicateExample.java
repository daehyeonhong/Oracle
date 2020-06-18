package ch06;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	private static List<Student> list = Arrays.asList(new Student("홍길동", "남자", 90), new Student("일지매", "여자", 90),
			new Student("홍길순", "여자", 95), new Student("임꺽정", "남자", 92));

	public static double avg(Predicate<Student> predicate) {
		int count = 0, sum = 0;
		for (Student student : list) {
			if (predicate.test(student)) {
				count++;
				sum += student.getEng();
			}
		}
		return (double) sum / count;
	}

	public static void main(String[] args) {
		double maleAvg = avg(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getGender().equals("남자");
			}
		});
		System.out.println("남자 평균: " + maleAvg);

		double femaleAvg = avg(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getGender().equals("여자");
			}
		});
		System.out.println("여자 평균: " + femaleAvg);

		System.out.println("람다식>>>");

		maleAvg = avg(t -> t.getGender().equals("남자"));
		System.out.println("남자 평균: " + maleAvg);

		femaleAvg = avg(t -> t.getGender().equals("여자"));
		System.out.println("여자 평균: " + femaleAvg);
	}
}