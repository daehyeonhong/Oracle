package ch06;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TextCopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\windows\\system.ini");
		File dest = new File("c:\\tmp\\system.txt");
		try (FileReader fr = new FileReader(src); FileWriter fw = new FileWriter(dest);) {
			int c;
			while ((c = fr.read()) != -1) {
				fw.write((char) c);
			}
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}