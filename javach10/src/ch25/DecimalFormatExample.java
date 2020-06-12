package ch25;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		double num = 1234567.89;

		DecimalFormat df = new DecimalFormat("0");// 소수점에서 반올림 정수형태 출력
		System.out.println(df.format(num));

		String[] format = { "0.0", "00000000.00000", "#", "#.#", "########.#####", "#.0", "+#.0", "-#.0", "#,###.0",
				"0.0E0", "+#,###;0#,###", "#.#%", "\u00A4 #,###" };
		int count = 0;

		for (String forNum : format) {
			count++;
			df = new DecimalFormat(forNum);// 실수형태 출력,둘째자리에서 반올림
			System.out.println(count + "번째 형태:" + forNum + "\n결과:" + df.format(num));
		}

		df = new DecimalFormat("0.0");// 실수형태 출력,둘째자리에서 반올림
		System.out.println(df.format(num));

		df = new DecimalFormat("00000000.00000");// 실수형태
		System.out.println(df.format(num));// 01234567.89000

		df = new DecimalFormat("#");// 1234568
		System.out.println(df.format(num));

		df = new DecimalFormat("#.#");// 1234567.9
		System.out.println(df.format(num));

		df = new DecimalFormat("########.#####");// 1234567.89
		System.out.println(df.format(num));

		df = new DecimalFormat("#.0");// 1234567.9
		System.out.println(df.format(num));

		df = new DecimalFormat("+#.0");// +1234567.9
		System.out.println(df.format(num));

		df = new DecimalFormat("-#.0");// -1234567.9
		System.out.println(df.format(num));

		df = new DecimalFormat("#,###.0");// 1,234,567.9
		System.out.println(df.format(num));

		df = new DecimalFormat("0.0E0");// 1.2E6
		System.out.println(df.format(num));

		df = new DecimalFormat("+#,###;0#,###");// +1,234,568
		System.out.println(df.format(num));

		df = new DecimalFormat("#.#%");// 123456789%
		System.out.println(df.format(num));

		df = new DecimalFormat("\u00A4 #,###");// ￦ 1,234,568
		System.out.println(df.format(num));
	}
}