package ch03;

import java.io.FileInputStream;

public class FileInputStreamExample {
	public static void main(String[] args) {
		byte[] bytes = new byte[4];
		try (FileInputStream fin = new FileInputStream("c:\\tmp\\test1.dat")) {
			int c, n = 0;
			while ((c = fin.read()) != -1) {
				bytes[n++] = (byte) c;
			}
			System.out.println("출력");
			for (int i = 0; i < bytes.length; i++) {
				System.out.print(bytes[i] + ", ");
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}