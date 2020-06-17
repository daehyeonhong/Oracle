package ch03;

import java.io.FileOutputStream;

public class FileOutputStreamExample {
	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream("c:\\tmp\\test1.dat")) {
			byte[] bytes = { 4, -1, 47, 30 };
			for (int i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}