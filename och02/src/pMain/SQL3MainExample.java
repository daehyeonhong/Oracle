package pMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.DAO;

public class SQL3MainExample {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		// 2.DB연결맺기
		Connection con = dao.getConnection();
		// 3.Query객체 생성
		// 4.Query 실행 밎 결과 받기
		int dno = 60;
		String dname = "SALES";
		String loc = "NEW YORK";

		String sql = "insert into dept values(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 값 바인딩 처리
		pstmt.setInt(1, dno);
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);

		System.out.println("쿼리문: " + sql);
		// executeUpdate()method - 실행 후 DB에 반영된 행수(건수)를 리턴하는 함수
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("입력 성공!");
		} else {
			System.out.println("입력 실패!");
		}
	}
}