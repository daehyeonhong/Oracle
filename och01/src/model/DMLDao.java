package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DMLDao {
	private static DMLDao instance = new DMLDao();

	private DMLDao() {
	}

	public static DMLDao getInstance() {
		return instance;
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// static 초기화

	// 4가지 패턴 중 하나, 매개변수 없고 객체를 리턴 하는 타입의 메소드
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}