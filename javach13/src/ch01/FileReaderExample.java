package ch01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//문자단위 입력 Reader -FileReader
//public class FileReaderExample {
//	public static void main(String[] args) throws IOException {
//		FileReader reader = new FileReader("c:\\tmp\\test.txt");
//		int c;
//		/*
//		 * while ((c = reader.read()) != -1) { System.out.println(c + "\t->\t" + ((char)
//		 * c)); }
//		 */
//		while ((c = reader.read()) != -1) {
//			System.out.print((char) c);
//		}
//	}
//}
public class FileReaderExample {
	public static void main(String[] args) throws IOException {
		try (FileReader reader = new FileReader("c:\\tmp\\test.txt");) {
			int c;
			while ((c = reader.read()) != -1) {// reader.read() [return_type]:Integer, 입력된 값의 아스키 코드 값
				System.out.print((char) c);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}