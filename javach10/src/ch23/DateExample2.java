package ch23;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample2 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E요일) hh시 mm분 ss초");
		String date = sdf.format(new Date());
		System.out.println(date);
	}
}