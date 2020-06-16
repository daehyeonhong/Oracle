package ch01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		// single thread
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();// 비프음
			try {
				Thread.sleep(500);// sleep(밀리초1/1000)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("삡");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// main()끝.
}