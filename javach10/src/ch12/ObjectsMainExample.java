package ch12;

import java.util.Objects;

public class ObjectsMainExample {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Objects.equals(obj1, obj2);
		System.out.println(Objects.equals(obj1, obj2));// false
		System.out.println(Objects.equals(obj1, null));// false
		System.out.println(Objects.equals(null, obj2));// false
		System.out.println(Objects.equals(null, null));// true
		System.out.println(Objects.equals(obj1, obj1));// equals() 결과 true
	}
}