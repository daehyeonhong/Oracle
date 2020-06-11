package ch15;

public class SystemEnvExample {
	public static void main(String[] args) {
		// 환경변수 읽어오기 메소드 getenv(Key);
		String javaHome = System.getenv("JAVA_HOME");
		System.out.println("JAVA_HOME: " + javaHome);
	}
}