package pMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.DAO;

public class SQL1MainExample {
	public static void main(String[] args) throws SQLException {
		// 1.DB연결객체 생성
		DAO dao = DAO.getInstance();
		// 2.DB연결맺기
		Connection con = dao.getConnection();
		// 3.Query객체 생성
		// Statement stmt = con.createStatement();
		String ename = "SMITH";
		// 쿼리 탬플릿 생성
		String sql = "select job,salary,hiredate from EMPLOYEE where ename=?";
		// 쿼리 객체 생성
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 바인딩 변수(?)에 값 셋팅
		pstmt.setString(1, ename);

		// 4.Query 실행 밎 결과 처리
		ResultSet rs = pstmt.executeQuery();
		// select한 결과 행이 한개인 경우 if(rs.next())로 확인

		if (rs.next()) {// select한 결과가 존재하면 처리
			String job = rs.getString(1);
			int salary = rs.getInt(2);
			String hiredate = rs.getString(3);
			System.out.println(job + "\t||" + salary + "\t||" + hiredate);
		}

		// 자원 해제
		rs.close();
		pstmt.close();
		con.close();
	}
}