package model;

import java.sql.Connection;

public class ConnectionTest {
	public static void main(String[] args) {
		// database 연결 테스트
		Dao dao = Dao.getInstance();
		Connection con = dao.getConnection();
		if (con != null) {
			System.out.println("database 연결 성공!");
		} else if (con == null) {
			System.out.println("database 연결 실패!");
		}
	}
}