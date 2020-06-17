package ch01;

import java.awt.Toolkit;

public class BeepPrintExample2 {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// 출력
		for (int i = 1; i <= 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);// 500밀리 초 = 0.5초 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 사운드
		for (int i = 1; i <= 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);// 500밀리 초 = 0.5초 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}