package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLMainExam {
	public static void main(String[] args) throws SQLException {
		// 1.db 연결객체 생성
		DMLDao dao = DMLDao.getInstance();
		// 2.db 연결 맺기
		Connection con = dao.getConnection();
		// 3.쿼리 전달 객체 생성
		Statement stmt;

		stmt = con.createStatement();

		// 4.쿼리 실행
		String sql = "create table dt(dna number(2), dname varchar2(14),loc varchar2(20))";
		stmt.executeQuery(sql);
	}
}