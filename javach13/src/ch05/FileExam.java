package ch05;

import java.io.File;

public class FileExam {
	public static void listDirectory(File file) {
		System.out.println("──────" + file.getPath() + "의 서브 리스트입니다────────");
		File[] subfiles = file.listFiles();
		for (int i = 0; i < subfiles.length; i++) {
			File f = subfiles[i];
			long t = f.lastModified();// 생성 혹은 수정된 날짜
			System.out.print(f.getName());
			System.out.print("\t파일 크기: " + f.length());// 파일 사이즈
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n", t, t, t, t);
		}
	}

	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());

		String res = "";
		if (f1.isFile()) {
			res = "파일";
		} else if (f1.isFile()) {
			res = "디렉토리";
		}
		System.out.println(f1.getName() + "은 " + res + "입니다");

		File f2 = new File("C:\\tmp\\java_sample");
		if (!f2.exists()) {// 파일 존재 여부 확인
			f2.mkdir();// 존재하지 않으면 디렉토리 생성
		}
		listDirectory(new File("c:\\tmp"));
		f2.renameTo(new File("c:\\tmp\\javasample"));
		listDirectory(new File("c:\\tmp"));
	}
}