package sMain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DAO;

public class ExecuteMainExample {
	public static void main(String[] args) throws SQLException {
		// 1.DB연결객체 생성
		DAO dao = DAO.getInstance();
		// 2.DB연결 맺기
		Connection con = dao.getConnection();
		// 3.Query객체 생성
		Statement stmt = con.createStatement();
		// 4.Query 실행 및 결과 받기
		// String sql = "select dno,dname,loc from dept";
		String sql = "update employee set ename='SCOTT' where eno=7788";
		boolean isTrue = stmt.execute(sql);
		System.out.println("isTrue: " + isTrue);

		if (isTrue) {// select
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				// 결과출력
				System.out.println(rs.getInt(1) + "::" + rs.getString(2) + "::" + rs.getString(3));
			}
		} else {// insert||update||delete
			int result = stmt.getUpdateCount();

			if (result > 0) {
				System.out.println("처리성공");
			} else {
				System.out.println("처리실패");
			}
		}
	}
}