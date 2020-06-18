package ch06;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInput1Example {
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("파일명> ");
			String fileName = br.readLine();
			System.out.print("저장할 내용> ");
			String content = br.readLine();
			try (FileWriter fw = new FileWriter(fileName);) {
				fw.write(content);
				System.out.println("저장 성공!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}