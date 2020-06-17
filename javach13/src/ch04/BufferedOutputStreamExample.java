package ch04;

import java.io.BufferedOutputStream;
import java.io.FileReader;

public class BufferedOutputStreamExample {
	public static void main(String[] args) {
		try (BufferedOutputStream bos = new BufferedOutputStream(System.out, 20);
				FileReader fr = new FileReader("c:\\windows\\system.ini");) {
			int c;
			while ((c = fr.read()) != -1) {
				bos.write((char) c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}