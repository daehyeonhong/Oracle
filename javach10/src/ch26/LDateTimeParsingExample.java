package ch26;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LDateTimeParsingExample {
	public static void main(String[] args) {
		DateTimeFormatter formatter;
		LocalDate localDate;

		// String->Date
		localDate = LocalDate.parse("2024-05-21");
		System.out.println(1 + "번" + localDate);

		// 입력된 문자열이 ISO_LOCAL_DATE 형식이면 localDate 타입으로 변환
		// ISO_LOCAL_DATE:"yyyy-MM-dd"
		formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		localDate = LocalDate.parse("2024-05-21", formatter);
		System.out.println(2 + "번" + localDate);

		//
		formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		localDate = LocalDate.parse("2024/05/21", formatter);
		System.out.println(3 + "번" + localDate);

		formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		localDate = LocalDate.parse("2024.05.21", formatter);
		System.out.println(4 + "번" + localDate);

		formatter = DateTimeFormatter.ofPattern("yyyyㅁMMㅁdd");
		localDate = LocalDate.parse("2024ㅁ05ㅁ21", formatter);
		System.out.println(5 + "번" + localDate);
	}
}