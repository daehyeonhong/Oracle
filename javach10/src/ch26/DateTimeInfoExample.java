package ch26;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeInfoExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		System.out.println(now.getYear() + "년" + now.getMonth() + "월" + now.getDayOfMonth() + "일" + now.getDayOfWeek()
				+ "요일" + now.getHour() + "시" + now.getMinute() + "분" + now.getSecond() + "초");
		// 로컬 데이터로 변경 후
		LocalDate nowDate = now.toLocalDate();
		System.out.println(nowDate.isLeapYear() ? "윤년" : "평년");

		// 협정세계시 존오프셋
		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("협정 세계시: " + utcDateTime);
		ZoneOffset seoulZoneOffset = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).getOffset();
		System.out.println("서울 존오프셋: " + seoulZoneOffset);
	}
}