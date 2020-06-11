package ch18;

public class ValueOfExample {
	public static void main(String[] args) {
		System.out.println(String.valueOf(true));
		String str1 = String.valueOf(10);
		System.out.println(str1.length());
		String str2 = String.valueOf(3.14);
		System.out.println(str2.length());
	}
}