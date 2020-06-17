package ch02;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterExample2 {
	public static void main(String[] args) {
		System.out.print("입력\n─>");
		try (Scanner scanner = new Scanner(System.in); FileWriter writer = new FileWriter("c:\\tmp\\test3.txt")) {
			while (true) {
				String line = scanner.nextLine();
				if (line.length() == 0) {
					break;
				}
				writer.write(line, 0, line.length());
				writer.write("\r\n", 0, 2);
			}
		} catch (Exception e) {
		}

		// 저장된 내용을 FileReader로 출력
		try (FileReader reader = new FileReader("c:\\tmp\\test3.txt")) {
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}