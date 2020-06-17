package ch01;

import java.io.FileReader;

public class FileReaderEx {
	public static void main(String[] args) {
		try (FileReader fin = new FileReader("c:\\windows\\system.ini")) {
			int c;
			while ((c = fin.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}