package ch04;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.util.Scanner;

public class BufferOutEx {
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("c:\\tmp\\test5.txt");
				BufferedOutputStream bos = new BufferedOutputStream(System.out, 5);
				Scanner scanner = new Scanner(System.in)) {
			int c;
			while ((c = fr.read()) != -1) {// read() return 값은 읽은 값을 그대로 리턴
				bos.write(c);
			}
			bos.flush();// BufferStream에 남아있는 Data를 밀어내기처리
			System.out.println(scanner.nextLine());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}