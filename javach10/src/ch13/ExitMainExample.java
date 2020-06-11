package ch13;

public class ExitMainExample {
	public static void main(String[] args) {
		// 보안 관리자 설정
		System.setSecurityManager(new SecurityManager() {
			// 재정의
			@Override
			public void checkExit(int status) {
				if (status != 5) {
					throw new SecurityException();
				}
			}

		});
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "번째");
			try {
				System.exit(i);// checkExit(i)도 실행 됨
			} catch (Exception e) {
				System.out.println(i + "예외 발생하여 exit() 메소드 미실행");
			}
		}
	}
}