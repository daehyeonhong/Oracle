package ch12;

import java.util.Objects;

public class ObjectsEqualsExample {
	public static void main(String[] args) {
		System.out.println(Objects.equals(new String("hello"), new String("hello")));// true
		System.out.println(Objects.equals(new String("hello"), null));// false
		System.out.println(Objects.equals(null, new String("hello")));// false
		System.out.println(Objects.equals(null, null));// true

		// 배열
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		System.out.println(Objects.equals(arr1, arr2));
		System.out.println(Objects.deepEquals(arr1, arr2));// 배열 안의 내용 비교
	}
}