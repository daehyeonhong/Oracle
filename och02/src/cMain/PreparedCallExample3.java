package cMain;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import dao.DAO;

public class PreparedCallExample3 {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		String sql = "{call SP_SALARY_ENAME2(?,?)}";
		CallableStatement cstmt = con.prepareCall(sql);
		// 값 바인딩 처리
		// out모드 바인딩 처리
		cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
		System.out.print("조회하려는 사원의 이름 입력>");
		String ename = scanner.next();
		// in모드 바인딩 처리
		cstmt.setString(1, ename);
		// 실행
		cstmt.execute();
		// 결과 출력
		System.out.println(cstmt.getInt(2));
		cstmt.close();
		con.close();
		scanner.close();
	}
}