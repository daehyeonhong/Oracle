package pMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import dao.DAO;

public class PreparedMainExample4 {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		// preparedStatement
		String sql = "select eno,ename,a.dno,dname from EMPLOYEE a,DEPARTMENT b"
				+ " where a.dno=b.dno and job=?and a.dno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 바인딩 변수 값 처리
		System.out.print("업무 입력>");
		String job = scanner.next();
		System.out.print("부서번호 입력>");
		int dno = scanner.nextInt();
		pstmt.setString(1, job);
		pstmt.setInt(2, dno);
		// 결과 처리
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int index = 0;
			System.out.println(rs.getInt(++index) + "\t|" + rs.getString(++index) + "\t|" + rs.getInt(++index) + "\t|"
					+ rs.getString(++index));
		}
		rs.close();
		pstmt.close();
		con.close();
		scanner.close();
	}
}