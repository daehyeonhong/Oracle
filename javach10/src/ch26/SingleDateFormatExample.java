package ch26;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleDateFormatExample {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yy년MM월dd일 H시mm분ss초");
		String sDate = sdf.format(now);
		System.out.println(sDate);
		System.out.println(new SimpleDateFormat("yy년의 D일이 지났습니다.").format(new Date()));
		System.out.println(new SimpleDateFormat("yy년의 w주가 지났습니다.").format(new Date()));
		System.out.println(new SimpleDateFormat("yy년의 MM월의 W주가 지났습니다.").format(new Date()));
	}
}