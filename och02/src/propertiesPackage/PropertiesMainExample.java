package propertiesPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PropertiesMainExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		// 연결객체 생성
		DAO dao = DAO.getIstance();
		// 연결맺기
		Connection con = dao.getConnection();
		// 쿼리객체 생성
		String sql = "select eno,ename,salary from EMPLOYEE where dno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.print("부서번호를 입력하세요>");
		int dno = scanner.nextInt();
		pstmt.setInt(1, dno);
		// 쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3));
		}
		scanner.close();
		pstmt.close();
		con.close();
	}
}