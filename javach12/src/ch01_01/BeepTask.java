package ch01_01;

import java.awt.Toolkit;

//run()method를 가진 BeepTaskClass
public class BeepTask implements Runnable {
	@Override
	public void run() {
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
	}// run()method 끝.
}