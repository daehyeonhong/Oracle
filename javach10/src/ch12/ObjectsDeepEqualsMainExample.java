package ch12;

import java.util.Objects;

public class ObjectsDeepEqualsMainExample {
	public static void main(String[] args) {
		Integer[] arr1 = { 1, 2 };
		Integer[] arr2 = { 1, 2 };
		Integer[] arr3 = { 1, 3 };
		// 배열의 내용이 모드 같은 경우 deepEquals()결과 true
		System.out.println(Objects.deepEquals(arr1, arr2));
		System.out.println(Objects.deepEquals(arr2, arr3));
	}
}