package ch02;

import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterExample {
	public static void main(String[] args) {
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
	}
}