package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BBMainExample3 {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		// 1.DB객체 얻기
		Dao dao = Dao.getInstance();
		// 2.DB연결
		Connection con = dao.getConnection();
		// 3.조회 객체 얻기
		String sql = "select*from bb order by seq";
		Statement stmt = con.createStatement();
		// 4.결과 처리
		// 쿼리 실행후 결과 받기
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("순번\t|타이틀\t\t|\t조회수\t|등록일|좋아요\t|싫어요");
		System.out.println("----------------------------------------");
		while (rs.next()) {
			int seq = rs.getInt(1);// 1번
			String title = rs.getString("title");// 칼럼명
			String content = rs.getString(3);// 순번3
			int cnt = rs.getInt(4);// 순번4
			String regdate = rs.getString(5);// 순번5
			int good = rs.getInt(6);
			int bad = rs.getInt(7);
			System.out.println(seq + "|\t" + title + "\t|" + cnt + "\t|" + content + "|" + "|\t\t\t\t\t"
					+ regdate.substring(0, 10) + "\t|" + good + "\t|" + bad);
		}
		System.out.print("상세조회할 글 번호를 입력하세요>");
		int seq = scanner.nextInt();
		rs = stmt.executeQuery("select content from bb where seq=" + seq);
		if (rs.next()) {
			String content = rs.getString("content");
			System.out.println(seq + ":" + content);
		}
		// 조회수 증가처리
		sql = "update bb set readcnt=readcnt+1 where seq=" + seq;
		stmt.executeUpdate(sql);
		scanner.close();
	}
}