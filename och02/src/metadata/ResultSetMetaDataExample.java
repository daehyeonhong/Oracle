package metadata;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import propertiesPackage.DAO;

public class ResultSetMetaDataExample {
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

		// 메타데이터 정보 객체 얻기
		ResultSetMetaData rsmd = rs.getMetaData();
		// 조회된 칼럼 갯수
		int cols = rsmd.getColumnCount();
		// 칼럼 목록 보기
		for (int i = 0; i < cols; i++) {
			System.out.println(rsmd.getColumnClassName(i) + "\t");
		}
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3));
		}
		System.out.println("\n-----------------------------");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t|" + rs.getString(2) + "\t|" + rs.getString(3));
		}
		scanner.close();
		pstmt.close();
		con.close();
	}
}