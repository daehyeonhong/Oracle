package ch26;

import java.time.LocalDateTime;

public class DateTimeOperationExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("현재 시:" + now);

		LocalDateTime targetDateTime = now.plusYears(1).minusMonths(2).plusDays(3).plusHours(4).plusMinutes(5)
				.plusSeconds(6);
		System.out.println(targetDateTime);
	}
}