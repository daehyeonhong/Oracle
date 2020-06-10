package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDao {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static MemberDao instance = new MemberDao();

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		return instance;
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
