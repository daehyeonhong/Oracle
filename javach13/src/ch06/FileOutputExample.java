package ch06;

import java.io.FileReader;
import java.util.Scanner;

public class FileOutputExample {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("읽을 파일> ");
			String fileName = scanner.nextLine();
			try (FileReader fr = new FileReader(fileName);) {
				int i = 0;

				while ((i = fr.read()) != -1) {
					System.out.print((char) i);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}