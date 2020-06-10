package pMain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DAO;

public class ExecuteMainExample2 {
	static DAO dao = null;
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) throws SQLException {
		// 1.DB연결객체 생성
		dao = DAO.getInstance();
		// 2.DB연결 맺기
		con = dao.getConnection();
		// 3.Query객체 생성
		stmt = con.createStatement();
		// 4.Query 실행 및 결과 받기
		int dno = 60;
		String sql = "delete from dept where dno=" + dno;
		boolean isTrue = myExcute(sql);
		System.out.println(isTrue);
		// 자원해제
		rs.close();
		stmt.close();
		con.close();
	}

	private static boolean myExcute(String sql) {

		if (sql.substring(0, 6).equals("select")) {
			try {
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				int result = stmt.executeUpdate(sql);
				if (result > 0) {
					return false;
				}
			} catch (SQLException e) {
			}
		}
		return false;
	}

}