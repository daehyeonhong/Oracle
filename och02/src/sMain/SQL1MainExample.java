package sMain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dao.DAO;

public class SQL1MainExample {
	public static void main(String[] args) throws SQLException {
		// 1.DB연결객체 생성
		DAO dao = DAO.getInstance();
		// 2.DB연결맺기
		Connection con = dao.getConnection();
		// 3.Query객체 생성
		Statement stmt = con.createStatement();
		// 4.Query 실행 밎 결과 처리
		String sql = "select job,salary,hiredate from EMPLOYEE where ename='SMITH'";
		ResultSet rs = stmt.executeQuery(sql);
		// select한 결과 행이 한개인 경우 if(rs.next())로 확인

		if (rs.next()) {// select한 결과가 존재하면 처리
			String job = rs.getString(1);
			int salary = rs.getInt(2);
			String hiredate = rs.getString(3);
			System.out.println(job + "\t||" + salary + "\t||" + hiredate);
		}

		// 자원 해제
		rs.close();
		stmt.close();
		con.close();
	}
}