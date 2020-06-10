package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointExample2 {
	public static void main(String[] args) throws SQLException {
		// 1.DB연결객체 얻기
		Dao dao = Dao.getInstance();
		// 2.DB연결맺기
		Connection con = dao.getConnection();
		con.setAutoCommit(false);
		// 3.쿼리객체 생성
		Statement stmt = con.createStatement();
		// 4.쿼리실행
		stmt.executeUpdate("delete from test_save where dno=40");
		// 조회
		ResultSet rs = stmt.executeQuery("select*from test_save");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		}
		// savepoint 설정
		Savepoint s1 = con.setSavepoint("s1");
		System.out.println("Savepoint s1 지정----");
		stmt.executeUpdate("delete from test_save where dno=30");
		// 조회
		rs = stmt.executeQuery("select*from test_save");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		}
		con.rollback(s1);// savepoint까지 rollback
		System.out.println("Savepoint s1까지 rollback----");
		rs = stmt.executeQuery("select*from test_save");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		}
		con.setAutoCommit(true);// 자동 모드로 복귀
	}
}