package ch26;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
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

		// 날짜
		System.out.println("[종료까지 남은 기간]");
		Period period = Period.between(startDateTime.toLocalDate(), targetDateTime.toLocalDate());
		System.out.println("남은 기간: " + period.getYears() + "년 " + period.getMonths() + "개월 " + period.getDays() + "일");

		// 시간
		Duration duration = Duration.between(startDateTime.toLocalTime(), targetDateTime.toLocalTime());
		System.out.println("남은 초:" + duration.getSeconds());

		targetDateTime = LocalDateTime.of(2019, 10, 16, 0, 0, 0);
		remainDays = startDateTime.until(targetDateTime, ChronoUnit.DAYS);
		System.out.println(remainDays);
	}
}