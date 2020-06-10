package pMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.DAO;

public class PreparedMainExample2 {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();

		String sql = "select eno,ename,job,salary,dname from EMPLOYEE a,DEPARTMENT b"
				+ " where a.dno=b.dno and hiredate>? and a.dno=? and a.job like ?";
		String hiredate = "87/05/05";
		int dno = 20;
		String job = "CLERK";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, hiredate);
		pstmt.setInt(2, dno);
		pstmt.setString(3, job);
		ResultSet rs = pstmt.executeQuery();
		// 결과 출력

		while (rs.next()) {
			int eno = rs.getInt(1);
			String ename = rs.getString(2);
			job = rs.getString(3);
			int salary = rs.getInt(4);
			String dname = rs.getString(5);
			System.out.println(eno + "|" + ename + "|" + job + "|" + salary + "|" + dname);
		}
	}
}