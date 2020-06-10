package ch01;

//ch01.Dog cannot be cast to ch01.Cat
public class CannotCastExceptionExample {
	public static void main(String[] args) {
		// 자식 클래스 생성 후 부모 타입으로 프로모션
		Animal animal = new Dog();
		if (animal instanceof Cat) {
			System.out.println("캐스팅 가능!");
			Cat cat = (Cat) animal;
		} else {
			System.out.println("캐스팅 불가!");
		}
		// 프로모션 된 부모 타입에서 다른 타입의 자식 클래스로 casting은 실제로 불가
		Cat cat = (Cat) animal;
	}
}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}