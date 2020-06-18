package ch05;

import java.io.File;
import java.io.IOException;

public class FileExample2 {
	public static void main(String[] args) throws IOException {
		File dir = new File(".");// .현재 DIR, .. 상위 DIR
		System.out.println("Read: " + dir.canRead());// 속성 읽기 여부
		System.out.println("Write: " + dir.canWrite());// 속성 쓰기 여부
		System.out.println("절대경로: " + dir.getAbsolutePath());// 절대 경로
		System.out.println("표준경로: " + dir.getCanonicalPath());// 상대 경로
		System.out.println("최종수정: " + dir.lastModified());// 최종 수정
		System.out.println("사이즈: " + dir.length());// 길이|사이즈
		System.out.println("parent: " + dir.getParent());// 상위 경로
		System.out.println("parent: " + dir.getParentFile());
		System.out.println("Path: " + dir.getPath());
		System.out.println("hidden: " + dir.isHidden());// 숨김 여부
	}
}