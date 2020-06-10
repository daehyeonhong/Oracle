package cMain;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import dao.DAO;

public class PreparedCallExample {
	public static void main(String[] args) throws SQLException {
		// 연결객체 생성
		DAO dao = DAO.getInstance();
		// 연결 맺기
		Connection con = dao.getConnection();
		// procedure실행 객체 생성
		// "{call [prosedure_name(argument)]}";
		String sql = "{call pr_emp_upsal(?)}";
		// procedure 문 실행
		CallableStatement cstmt = con.prepareCall(sql);
		// 출력용 변수 설정 registerOutParameter(index,SQLtype);
		cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);// 출력용 변수 값
		cstmt.execute();// procedure 실행
		System.out.print("인상 후 급여 총액: " + Math.round(cstmt.getDouble(1)));
	}
}