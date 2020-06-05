package pMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.DAO;

public class SQL2MainExample {
	public static void main(String[] args) throws SQLException {
		// 1.DB연결객체 생성
		DAO dao = DAO.getInstance();
		// 2.DB연결맺기
		Connection con = dao.getConnection();
		// 3.Query객체 생성
		String sql = "select ename,job,salary,hiredate from EMPLOYEE where dno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 10);
		// 4.Query 실행 밎 결과 처리
		ResultSet rs = pstmt.executeQuery();
		// select한 결과 행이 여러 건인 경우 while(rs.next())로 확인

		while (rs.next()) {// select한 결과가 존재하면 처리
			String name = rs.getString("ename");
			String job = rs.getString("job");
			int salary = rs.getInt("salary");
			String hiredate = rs.getString("hiredate");
			System.out.println(name + "\t||" + job + "\t||" + salary + "\t||" + hiredate);
		}
	}
}