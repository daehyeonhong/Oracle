package ch06;

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {
		// Supplier 매개변수없고 리턴타입만 있는 추상메소드
		IntSupplier intSupplier = () -> (int) (Math.random() * 6) + 1;
		System.out.println(intSupplier.getAsInt());
	}
}