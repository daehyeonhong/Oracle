package ch22;

public class MathMainExample {
	public static void main(String[] args) {
		System.out.println(Math.abs(-5));

		System.out.println(Math.ceil(5.3));// 6
		System.out.println(Math.ceil(-5.3));// -5

		System.out.println(Math.floor(5.3));// 5
		System.out.println(Math.floor(-5.3));// -6

		System.out.println(Math.max(5, 9));// 9
		System.out.println(Math.min(5, 9));// 5

		System.out.println(Math.rint(5.3));// 5.0 - 실수
		System.out.println(Math.rint(5.7));// 6.0 - 정수

		System.out.println(Math.round(5.3));// 5 - 정수
		System.out.println(Math.round(5.7));// 6 - 정수

		// 소수 2자리까지 반올림
		double value = 12.3456;
		double temp1 = value * 100;// 두자리 곱해서 정수로 변환
		long temp2 = Math.round(temp1);// 정수상태에서 반올림
		double v16 = temp2 / 100.0;// 두자리 나눠서 원래 실수로 변환
		System.out.println(v16);
	}
}