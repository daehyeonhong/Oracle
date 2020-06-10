package ch13;

public class ExitExample {
	public static void main(String[] args) {
		// 보안 관리자 설정
		System.setSecurityManager(new SecurityManager() {

			@Override
			public void checkExit(int status) {
				if (status != 5) {
					throw new SecurityException();
				}
			}
		});

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				System.exit(i);// exit()method 실행시 예외 발생 -checkExit()method가 실행
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}