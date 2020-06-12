package ch26;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeCompareExample {
	public static void main(String[] args) {
		LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 9, 0, 0);
		LocalDateTime targetDateTime = LocalDateTime.of(2024, 3, 31, 18, 0, 0);

		System.out.println(startDateTime);
		System.out.println(targetDateTime);

		System.out.println("[종료까지 남은 시간]");
		long remainYear = startDateTime.until(targetDateTime, ChronoUnit.YEARS);
		long remainMonths = startDateTime.until(targetDateTime, ChronoUnit.MONTHS);
		long remainDays = startDateTime.until(targetDateTime, ChronoUnit.DAYS);
		long remainHours = startDateTime.until(targetDateTime, ChronoUnit.HOURS);
		System.out.println("남은 해: " + remainYear + ", " + "남은 월: " + remainMonths + ", " + "남은 일: " + remainDays + ", "
				+ "남은 시: " + remainHours);
	}
}