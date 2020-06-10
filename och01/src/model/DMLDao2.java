package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
public class DMLDao2 {
	// 자신 타입의 private 필드 선언 및 초기화
	private static DMLDao2 instance = new DMLDao2();

	// 기본 생성자를 private로 캡슐화
	private DMLDao2() {
	}

	// public으로 선언된(외부에서 접근 가능한 메소드)메소드 선언
	public static DMLDao2 getInstance() {
		return instance;
	}

	// static 초기화 블럭
	static {
		try {// 파일로 저장되어있는 라이브러리를 static영역에 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	// db연결맺기 메소드 선언
	// method 4가지 타입:매개변수 있고 return,매개변수 없고 return,매개변수 있고 void,매개변수 없고void
	public Connection getConnection() {
		// Connection con = new Connection();//인터페이스는 new로 생성 불가
		// 대protocol:소protocol:드라이브타입:서버주소:port번호:서비스명(SID);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection con = null;// 로컬변수 초기화
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}