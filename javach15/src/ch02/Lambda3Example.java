package ch02;

public class Lambda3Example {
	public static void main(String[] args) {
		MyFunctionalInterface mf = x -> System.out.println(x + x);
		mf.method(5);
		mf = x -> System.out.println(x + 10);
		mf.method(5);
	}
}