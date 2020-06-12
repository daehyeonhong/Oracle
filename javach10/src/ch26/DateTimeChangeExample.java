package ch26;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DateTimeChangeExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		LocalDateTime targetDateTime = null;

		// 직접 변경
		targetDateTime = now.withYear(2024).withMonth(10).withDayOfMonth(5).withHour(5).withMinute(30).withSecond(20);
		System.out.println(targetDateTime);

		// 상대 변경
		targetDateTime = now.with(TemporalAdjusters.firstDayOfYear());
		System.out.println(targetDateTime);
		System.out.println(now.with(TemporalAdjusters.lastDayOfYear()));

		// 월 상대 변경
		System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()));

		// 요일 상대 변경
		System.out.println(now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		System.out.println(now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
		System.out.println(now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
	}
}