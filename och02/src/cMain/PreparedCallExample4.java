package cMain;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import dao.DAO;

public class PreparedCallExample4 {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		String sql = "{?=call FN_HIRE_ENO(?)}";
		CallableStatement cstmt = con.prepareCall(sql);
		// 출력용 바인딩 변수 타입 DATE
		cstmt.registerOutParameter(1, Types.DATE);
		System.out.print("사원번호를 입력하세요");
		int eno = 0;
		cstmt.setInt(2, eno);
		cstmt.execute();
		// 출력시 cstmt.getDate(index);
		System.out.print("입사일자: " + cstmt.getDate(1));
		cstmt.close();
		con.close();
		scanner.close();
	}
}