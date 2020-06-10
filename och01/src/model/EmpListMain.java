package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpListMain {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("조회할 입사연도를 입력하세요> ");
		String year = scanner.next();// "19870101"
		// 1.db연결 객체 얻기
		Dao dao = Dao.getInstance();
		// 2.db연결
		Connection con = dao.getConnection();
		// 3.쿼리객체 생성
		Statement stmt = con.createStatement();
		// 4.쿼리실행 및 결과 받기
		String sql = "select eno, ename, hiredate from EMPLOYEE where hiredate>=to_date('" + year + "')";
		System.out.println("쿼리문:" + sql);
		ResultSet rs = stmt.executeQuery(sql);
		// 5.결과출력
		while (rs.next()) {
			int eno = rs.getInt("eno");// getInt("eno")
			String ename = rs.getString("ename");// getString("ename")
			String hiredate = rs.getString("hiredate");// getString("hiredate")
			System.out.println(eno + "," + ename + "," + hiredate);
		}
		scanner.close();
	}
}