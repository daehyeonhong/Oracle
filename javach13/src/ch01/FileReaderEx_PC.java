package ch01;

import java.io.FileReader;

public class FileReaderEx_PC {
	public static void main(String[] args) {
		try (FileReader fin = new FileReader("c:\\tmp\\test2.txt")) {
			int c;
			while ((c = fin.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}