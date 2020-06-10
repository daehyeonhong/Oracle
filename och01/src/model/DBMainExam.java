package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMainExam {
	public static void main(String[] args) throws SQLException {
		// 1.값 입력-insert
		// 1.연결객체 생성-1회.
		Dao dao = Dao.getInstance();
		// 2.연결맺기-1회.
		Connection con = dao.getConnection();
		// 3.쿼리객체 생성-1회.
		Statement stmt = con.createStatement();
		// 4.쿼리 입력
		String sql = "insert into bb values(10,'제목4','내용4',5,'2012/05/05')";
		// 4-1.입력후 처리
		// executeUpdate(쿼리문)의 결과 처리된 데이터 건수(행:row)를 정수로 리턴
		int result = stmt.executeUpdate(sql);
		System.out.println("입력된 건 수: " + result);

		// 2.값 확인-select
		// 5.조회
		if (result > 0) {
			sql = "select*from bb order by seq";
			// 쿼리 실행 후 결과 받기
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int seq = rs.getInt(1);// 1번
				String title = rs.getString("title");// 칼럼명
				String content = rs.getString(3);// 순번3
				int cnt = rs.getInt(4);// 순번4
				String regdate = rs.getString(5);// 순번5
				System.out.println(seq + "|" + title + "|" + content + "|" + cnt + "|" + regdate);
			}
		}
	}
}