package ch06;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample {
	private static List<Student> list = Arrays.asList(new Student("홍길동", 90, 95), new Student("임꺽정", 95, 93));

	public static void printString(Function<Student, String> function) {
		for (Student student : list) {
			System.out.print(function.apply(student) + "\t");
		}
		System.out.println();
	}

	public static void printInt(ToIntFunction<Student> function) {
		for (Student student : list) {
			System.out.print(function.applyAsInt(student) + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("[학생이름]");
		printString(t -> t.getName());

		System.out.println("[영어점수]");
		printInt(i -> i.getEng());

		System.out.println("[수학점수]");
		printInt(i -> i.getMath());
	}
}

class Student {
	private String name, gender;
	private int eng, math;

	public Student(String name, int eng, int math) {
		this.name = name;
		this.eng = eng;
		this.math = math;
	}

	public Student(String name, String gender, int eng) {
		this.name = name;
		this.gender = gender;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getMath() {
		return math;
	}

	public int getEng() {
		return eng;
	}
}