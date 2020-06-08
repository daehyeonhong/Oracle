package jdbcrowset;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetSample {
	public static void main(String[] args) throws SQLException {
		// CachedRowSet 인터페이스에 URL,user,password,command method 제공
		// CachedRowSet jdbcRs = new CachedRowSetImpl();
		// JDK 1.7 이후 버전에서는 RowSetProvider를 이용하여 생성.
		CachedRowSet jdbcRs = RowSetProvider.newFactory().createCachedRowSet();
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String name = "hr";
		String password = "hr";
		String cmd = "select*from employee order by eno";

		jdbcRs.setUrl(url);
		jdbcRs.setUsername(name);
		jdbcRs.setPassword(password);
		jdbcRs.setCommand(cmd);

		// 실행
		jdbcRs.execute();

		// 결과 출력
		while (jdbcRs.next()) {
			System.out.println(jdbcRs.getInt(1) + ",\t" + jdbcRs.getString(2) + ",\t" + jdbcRs.getString(3));
		}

		// 자원해제
		jdbcRs.close();
	}// main()method 끝.
}