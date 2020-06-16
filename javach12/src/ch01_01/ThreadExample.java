package ch01_01;

import java.awt.Toolkit;

public class ThreadExample {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
		thread.start();
	}
}