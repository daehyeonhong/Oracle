package propertiesPackage;

import java.util.Properties;
import java.util.Scanner;

public class PropertiesMainExample2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Properties pro = new Properties();
		// setProperty(key,value);
		pro.setProperty("seoul", "28");
		pro.setProperty("beijing", "30");
		pro.setProperty("tokyo", "20");

		// 서울의 현재 온도는 몇 도입니까?
		// getProperty(key)
		String city = scanner.next();
		String celcius = pro.getProperty(city);
		System.out.println(city + "의 현재 기온은: " + celcius + "℃ 입니다.");
		scanner.close();
	}
}