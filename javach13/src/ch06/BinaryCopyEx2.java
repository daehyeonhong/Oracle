package ch06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryCopyEx2 {
	public static void main(String[] args) {
		File src = new File("c:\\tmp\\img1.jpg");
		File dest = new File("c:\\tmp\\copyImg.png");
		
		try (FileInputStream fi = new FileInputStream(src); FileOutputStream fo = new FileOutputStream(dest)) {
			byte[] buf = new byte[1024 * 10];// 10KB
			long startTime = System.currentTimeMillis();
			while (true) {
				int n = fi.read(buf);// buf에 저장된 길이가 리턴 됨.
				fo.write(buf, 0, n);// write(Array, 0, length)
				if (n < buf.length) {
					break;
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사 완료!");
			System.out.println("작업시간: " + (endTime - startTime));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}