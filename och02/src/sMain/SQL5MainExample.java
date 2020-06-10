package sMain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DAO;

public class SQL5MainExample {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		// 2.DB연결맺기
		Connection con = dao.getConnection();
		// 3.Query객체 생성
		Statement stmt = con.createStatement();
		// 4.Query 실행 밎 결과 받기
		int dno = 60;
		String sql = "delete from dept where dno=" + dno;
		System.out.println("쿼리문: " + sql);
		// executeUpdate()method - 실행 후 DB에 반영된 행수(건수)를 리턴하는 함수
		int result = stmt.executeUpdate(sql);

		if (result > 0) {
			System.out.println("삭제 성공!");
		} else {
			System.out.println("삭제 실패!");
		}

		// 자원해제 - 생성된 역순으로 해제
		stmt.close();
		con.close();
	}
}