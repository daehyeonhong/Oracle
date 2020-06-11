package ch04_01;

import java.util.Arrays;

public class Member implements Cloneable {
	public String name;// String field
	public int age;// default type field
	public int[] score;// reference type field
	public Car car;

	public Member(String name, int age, int[] score, Car car) {
		this.name = name;
		this.age = age;
		this.score = score;
		this.car = car;
	}

	// @Override
	// protected Object clone() throws CloneNotSupportedException {
	// Member cloned = (Member) super.clone();
	// cloned.score = Arrays.copyOf(this.score, this.score.length);
	// cloned.car = new Car(this.car.model);
	// return cloned;
	// }

	// 얕은 복제 기능의 clone() method를 깊은 복제 기능으로 Override
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Member cloned = (Member) super.clone();
		cloned.score = new int[this.score.length];
		for (int i = 0; i < this.score.length; i++) {
			cloned.score[i] = this.score[i];
		}
		cloned.car = new Car(this.car.model);
		return cloned;
	}

	public Member getMember() {
		Member cloned = null;
		try {
			cloned = (Member) clone(); // 재정의한 clone() method를 실행
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cloned;
	}// method end

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", score=" + Arrays.toString(score) + ", car=" + car + "]";
	}

}

class Car {
	String model;

	public Car(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + "]";
	}

}