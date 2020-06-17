package ch06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryCopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\tmp\\img1.jpg");
		File dest = new File("c:\\tmp\\copyImg.png");
		int c;

		long startTime = System.currentTimeMillis();
		try (FileInputStream fi = new FileInputStream(src); FileOutputStream fo = new FileOutputStream(dest)) {
			while ((c = fi.read()) != -1) {// [0][0][0][1]
				fo.write((byte) c);// byte 단위 처리[0][0][0][1]
			}
			long endTime = System.currentTimeMillis();
			System.out.println("작업시간: " + (endTime - startTime));
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사 완료!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}