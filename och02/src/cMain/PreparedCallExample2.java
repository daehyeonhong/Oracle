package cMain;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import dao.DAO;

//function
public class PreparedCallExample2 {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		// "{?=call [function_name](argument)}";
		String sql = "{?=call FN_SALARY_ENAME(?)}";// 첫 '?'==결과,두번째?==조건
		CallableStatement cstmt = con.prepareCall(sql);
		// 바인딩 변수 설정
		// 출력용 변수 설정 registerOutParameter(index,type);
		System.out.print("사원명 입력> ");
		String ename = scanner.next();
		cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		// 입력용 변수 설정 set_type(index,value);
		cstmt.setString(2, ename);
		// 실행
		cstmt.execute();
		// 결과 출력
		System.out.println("SALARY: " + cstmt.getInt(1));
		scanner.close();
		cstmt.close();
		con.close();
	}
}