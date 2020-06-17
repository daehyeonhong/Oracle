package ch04;

import java.io.FileWriter;
import java.io.IOException;

public class AutoSaveThread extends Thread {
	public void save(int i) {
		System.out.println(i + "번째 작업 내용을 저장합니다");
		try (FileWriter writer = new FileWriter("c:\\tmp\\save.txt", true)) {
			writer.write(i + "번째 자동저장\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {
			save(i);
			try {
				Thread.sleep(1000);// 1초 간격 멈춤
			} catch (Exception e) {
				break;
			}
			i++;
		} // while()끝
	}
}
