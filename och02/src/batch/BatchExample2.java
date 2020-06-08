package batch;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import propertiesPackage.ProDAO;

public class BatchExample2 {
	public static void main(String[] args) throws SQLException {
		ProDAO dao = ProDAO.getInsance();
		Connection con = dao.getConnection();
		Statement stmt = con.createStatement();
		con.setAutoCommit(false);

		// 일괄
		String sql;
		sql = "UPDATE DEPARTMENT SET LOC='엘에이'WHERE DNO=50";
		stmt.addBatch(sql);
		sql = "UPDATE DEPARTMENT SET LOC='달라스'WHERE DNO=20";
		stmt.addBatch(sql);
		sql = "UPDATE DEPARTMENT SET LOC='보스톤'WHERE DNO=40";
		stmt.addBatch(sql);

		// 일괄처리 작업 실행
		int[] result = stmt.executeBatch();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i] > 0 ? ((i + 1) + "번째 작업 성공!") : ((i + 1) + "번째 작업 실패!"));
		}
		// 일괄 작업이 모두 정상적으로 끝났는지 확인
		boolean isAllCompleted = false;
		for (int i = 0; i < result.length; i++) {
			if (result[i] > 0) {
				isAllCompleted = true;
			} else {
				isAllCompleted = false;
				break;
			}
		}
		// 하나라도 비정상이면 rollback, 모두 정상이면 commit;
		if (isAllCompleted) {
			con.commit();
		} else {
			// 자동 commit mode로 복귀
			con.rollback();
		}
		con.setAutoCommit(true);
		stmt.close();
		con.close();
	}
}