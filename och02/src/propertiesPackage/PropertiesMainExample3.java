package propertiesPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PropertiesMainExample3 {
	public static void main(String[] args) throws SQLException {
		ProDAO dao = ProDAO.getInsance();
		Connection c = dao.getConnection();
		String sql = "select dno,dname,loc from dept where dno=?";
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setInt(1, 10);
		// metadata(head)부분 제외하고 data부분만 출력
		// metadata 출력 rs.getMetaData()
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.print("칼럼수: " + rsmd.getColumnCount() + "\n");
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i) + "\t");
		}
		System.out.println("\n─────────────────────────────────────");
		if (rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		}
	}
}