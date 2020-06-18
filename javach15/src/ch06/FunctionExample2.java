package ch06;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionExample2 {
	private static List<Student> list = Arrays.asList(new Student("홍길동", 90, 60), new Student("임꺽정", 95, 93));

	// Student -> integer map
	public static double avg(ToIntFunction<Student> function) {
		int sum = 0;
		for (Student student : list) {
			sum += function.applyAsInt(student);// reduce 집계
		}
		double avg = (double) sum / list.size();
		return avg;
	}

	public static void main(String[] args) {
		double engAvg = avg(studentEng -> studentEng.getEng());
		System.out.println("영어점수 평균: " + engAvg);

	}
}