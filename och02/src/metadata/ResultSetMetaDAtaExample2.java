package metadata;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import propertiesPackage.DAO;

public class ResultSetMetaDAtaExample2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		DAO dao = DAO.getIstance();
		// 연결맺기
		Connection con = dao.getConnection();
		// 쿼리객체 생성
		String sql = "select eno,ename,salary from EMPLOYEE where dno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 10);
		// 쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnClassName(1));
		System.out.println(rsmd.getColumnClassName(2));
		System.out.println(rsmd.getColumnClassName(3));
		System.out.println(rsmd.getColumnName(1));
		System.out.println(rsmd.getColumnType(1));
		System.out.println(rsmd.getColumnDisplaySize(1));
		System.out.println(rsmd.getColumnTypeName(1));
		System.out.println(rsmd.getColumnLabel(1));
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnLabel(i) + "\t");
		}
	}
}