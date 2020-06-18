package ch01;

//객체 저장용 객체
public class MyClass<T> {// 제네릭 클래스 타입매개변수가 T
	T val;// val의 타입 T

	void set(T a) {// T타입의 값 저장
		val = a;
	}

	T get() {// 리턴 타입 T
		return val;
	}
}
