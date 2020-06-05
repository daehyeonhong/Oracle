package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.DAO;

public class TransactionMainExample {
	public static void main(String[] args) throws SQLException {
		DAO dao = DAO.getInstance();
		Connection con = dao.getConnection();
		// transaction 수동처리
		con.setAutoCommit(false);
		String sql = "delete from DEPARTMENT where dno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 바인딩변수 셋팅
		pstmt.setInt(1, 60);
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("삭제완료!");
			con.commit();// DB에 반영
		} else {
			System.out.println("삭제실패!");
			con.rollback();// 이전 상태로 되돌리기
		}
		sql = "select*from DEPARTMENT order by dno";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t|" + rs.getString(2) + "\t|" + rs.getString(3));
		}

		// 트랜잭션 자동처리
		con.setAutoCommit(true);
		pstmt.close();
		con.close();
	}
}