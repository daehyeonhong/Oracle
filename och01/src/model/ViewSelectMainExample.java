package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewSelectMainExample {
	public static void main(String[] args) throws SQLException {
		// 1.연결객체 생성
		Dao dao = Dao.getInstance();
		// 2.연결 맺기
		Connection con = dao.getConnection();
		// 3.쿼리객체 생성
		Statement stmt = con.createStatement();
		// 4.쿼리 실행 및 결과 보기
		String sql = "select*from v_emp_dname order by eno";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(4));
		}
	}
}