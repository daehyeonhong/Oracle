package propertiesPackage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ProDAO {
	private static ProDAO instance = new ProDAO();

	private ProDAO() {
	}

	public static ProDAO getInsance() {
		return instance;
	}

	// 연결객체생성
	public Connection getConnection() {
		Connection con = null;
		try {
			// properties파일로부터 정보 읽어오기
			FileInputStream fis = new FileInputStream("c:\\config\\dbconfig.properties");
			Properties pro = new Properties();
			pro.load(fis);
			String driver = pro.getProperty("driver");// "oracle.jdbc.driver.OracleDriver"
			String url = pro.getProperty("url");// jdbc:oracle:thin:@localhost:1521:xe
			String user = pro.getProperty("user");// hr
			String password = pro.getProperty("password");// hr
			// 드라이버 로딩
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}