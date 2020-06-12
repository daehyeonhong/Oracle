package ch26;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeCreateExample {
	public static void main(String[] args) throws InterruptedException {
		// 날짜 얻기->현재 날짜
		LocalDate currDate = LocalDate.now();
		System.out.println(currDate);
		System.out.println(LocalDate.now());

		// LocalDate.of(년,월,일) 날짜 셋팅
		LocalDate targetDate = LocalDate.of(2024, 5, 10);
		System.out.println(targetDate);

		// 시간 얻기
		LocalTime currTime = LocalTime.now();
		System.out.println(currTime);

		// LocalTime.of(시,분,초,밀리초)
		LocalTime targetTime = LocalTime.of(6, 30, 0, 0);
		System.out.println(targetTime);

		// 날짜와 시간 얻기
		LocalDateTime currDateTime = LocalDateTime.now();
		System.out.println(currDateTime);
		// LocalDateTime.of(년,월,일,시,분,초,밀리초)
		LocalDateTime targetDateTime = LocalDateTime.of(2024, 5, 10, 6, 30, 0, 0);
		System.out.println(targetDateTime);

		// 협정 세계시 시,분,초
		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("협정 세계시: " + utcDateTime);

		// 특정 지역의 시간
		ZonedDateTime newyorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("뉴욕 시간: " + newyorkTime);

		// 틀정 시점의 타임스탬프
		Instant instant1 = Instant.now();
		System.out.println(instant1);
		Thread.sleep(10);// 진행을 일시정지 메소드sleep(밀리초)
		Instant instant2 = Instant.now();
		// 타임스탬프상 이전,이후 isBefore, isAfter
		System.out.println(instant1.isBefore(instant2) ? "instant1이 빠르다!" : "instant2가 빠르다!");
		System.out.println(instant1.isAfter(instant2) ? "instant1이 늦다!" : "instant2이 늦다!");
	}
}