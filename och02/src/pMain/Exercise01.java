package pMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.DAO;

public class Exercise01 {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		// insert into EMPLOYEE values(7799,'홍길동','CLERK',7788,sysdate,1500,null,20)
		int eno = 7799;
		String ename = "홍길동";
		String job = "CLERK";
		int manager = 7788;
		// String hiredate = "sysdate";
		int salary = 1500;
		int dno = 20;
		String sql = "insert into EMPLOYEE values(?,?,?,?,sysdate,?,null,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, eno);
		pstmt.setString(2, ename);
		pstmt.setString(3, job);
		pstmt.setInt(4, manager);
		pstmt.setInt(5, salary);
		pstmt.setInt(6, dno);
		int result = pstmt.executeUpdate();

		if (result > 0) {
			System.out.println("입력성공!");
		} else {
			System.out.println("입력실패!");
		}
	}
}