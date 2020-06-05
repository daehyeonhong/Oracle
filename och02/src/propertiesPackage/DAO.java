package propertiesPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAO {
	private static DAO istance = new DAO();

	private DAO() {
	}

	public static DAO getIstance() {
		return istance;
	}

	public Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
		// jdbc.properties file과 이동통로 설정(stream)
		FileInputStream fis = new FileInputStream("c:\\config\\jdbc.properties");
		// jdbc.properties file 형태로 저장하기 위한 객체 생성
		Properties pro = new Properties();
		// key=value 형태로 객체에 저장 load(stream)
		pro.load(fis);// driver=oracle.jdbc.driver.OracleDriver
		Class.forName(pro.getProperty("driver"));
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("url: " + url);
		System.out.println("user: " + user);
		System.out.println("password: " + password);
		return con;
	}
}