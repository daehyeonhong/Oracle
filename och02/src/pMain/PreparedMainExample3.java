package pMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import dao.DAO;

public class PreparedMainExample3 {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		// 입력문
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		String sql = "insert into DEPARTMENT values(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.print("부서번호 입력>");
		int dno = scanner.nextInt();
		System.out.print("부서명 입력>");
		String dname = scanner.next();
		System.out.print("지역 입력>");
		String loc = scanner.next();
		pstmt.setInt(1, dno);
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);
		// 출력문
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("입력성공!");
		} else {
			System.out.println("입력실패!");
		}
		// 결과출력
		sql = "select dno,dname,loc from DEPARTMENT order by dno";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t|" + rs.getString(2) + "\t|" + rs.getString(3));
		}
		sql = "delete from DEPARTMENT where dno=60";
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.close();
		pstmt.close();
		con.close();
		scanner.close();
	}
}