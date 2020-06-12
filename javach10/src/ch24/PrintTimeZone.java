package ch24;

import java.util.Calendar;
import java.util.TimeZone;

public class PrintTimeZone {
	public static void main(String[] args) {
		// TimeZone 리스트 얻기
		String[] availableIDs = TimeZone.getAvailableIDs();
		for (String id : availableIDs) {
			System.out.println(id);
			TimeZone timeZone = TimeZone.getTimeZone(id);
			Calendar now = Calendar.getInstance(timeZone);
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH) + 1;// MONTH의 index + 1
			int day = now.get(Calendar.DATE);// 일
			System.out.println(year + "년" + month + "월" + day + "일" + " ");
			System.out.println(
					now.get(Calendar.HOUR) + "시" + now.get(Calendar.MINUTE) + "분" + now.get(Calendar.SECOND) + "초");
		}

	}
}