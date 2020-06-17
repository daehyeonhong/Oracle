package ch01;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderExample {
	public static void main(String[] args) throws IOException {
		// byte 단위의 stream을 2byte단위의 Reader로 변환

		InputStreamReader reader = new InputStreamReader(System.in);
		// read() [return_type]:int, 더이상 입력된 문자가 없으면 -1 return

		int c;
		while ((c = reader.read()) != -1) {
			System.out.println((char) c);
		}
	}
}