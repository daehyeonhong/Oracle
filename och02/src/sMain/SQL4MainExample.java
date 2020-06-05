package sMain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DAO;

public class SQL4MainExample {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		// 2.DB연결맺기
		Connection con = dao.getConnection();
		// 3.Query객체 생성
		Statement stmt = con.createStatement();
		// 4.Query 실행 밎 결과 받기
		int dno = 60;
		String loc = "DALLAS";
		String sql = "update dept set loc ='" + loc + "'where dno=" + dno;
		System.out.println("쿼리문: " + sql);
		// executeUpdate()method - 실행 후 DB에 반영된 행수(건수)를 리턴하는 함수
		int result = stmt.executeUpdate(sql);
		
		if (result > 0) {
			System.out.println("수정 성공!");
		} else {
			System.out.println("수정 실패!");
		}
	}
}