package ch06;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class UrlExample2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("소스를 보고 싶은 URL주소> ");
			// URL정보 객체 생성
			String str = scanner.nextLine();
			// 해당 URL 연결
			URL url = new URL(str);
			URLConnection uc = url.openConnection();// URL 접속하기
			// 입력 스트림 얻기 getInputStream();
			InputStream is = uc.getInputStream();// 입력 스트립 객체 얻기
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String data = "";
			// 읽어들인 정보 출력
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
			is.close();
			isr.close();
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}