package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLMainExam2 {
	public static void main(String[] args) throws SQLException {
		// 1.db연결객체 생성
		DMLDao2 dao = DMLDao2.getInstance();
		// 2.db연결 맺기
		Connection con = dao.getConnection();
		// 3.쿼리객체 생성
		Statement stmt = con.createStatement();
		// 4.쿼리 실행
		// 테이블이 존재하는지 확인 후 없으면 생성, 있으면 넘김
		String sql2 = "select count(*)tabcnt from user_tables where table_name=upper('dt')";
		ResultSet rs = stmt.executeQuery(sql2);
		if (rs.next()) {
			if (rs.getInt("tabcnt") > 0) {
				System.out.println("테이블이 존재합니다.");
			} else {
				String sql = "create table dt(dna number(2), dname varchar2(14),loc varchar2(13))";
				stmt.executeQuery(sql);
				System.out.println("테이블을 생성하였습니다.");
			} // else 끝.
		} // 바깥 if끝.
	}
}