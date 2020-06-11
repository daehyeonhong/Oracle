package ch15;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");

		System.out.println("운영체제: " + osName);
		System.out.println("사용자: " + userName);
		System.out.println("홈 디렉토리: " + userHome);

		// getProperties()환경 변수 값 출력 메소드
		// key(String)value(String)
		Properties prop = System.getProperties();
		// key=value ->Set
		Set keys = prop.keySet();
		// 향상된 for문
		for (Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println("[Key: " + key + "\t=\tvalue: " + value + "]");
		}
	}
}