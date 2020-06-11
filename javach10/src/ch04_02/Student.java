package ch04_02;

import java.util.Arrays;

//CloneNotSupportedException
public class Student implements Cloneable {
	String name;
	int[] scores;

	public Student(String name, int[] scores) {
		this.name = name;
		this.scores = scores;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student cloned = (Student) super.clone();
		cloned.scores = new int[this.scores.length];
		for (int i = 0; i < scores.length; i++) {
			cloned.scores[i] = this.scores[i];
		}
		return cloned;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", scores=" + Arrays.toString(scores) + "]";
	}

	public Student getStudent() {
		Student original = null;
		try {
			original = (Student) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return original;
	}
}