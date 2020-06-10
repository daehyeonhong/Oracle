package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SeqeunceMainExample {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		// 1.연결 객체 생성
		Dao dao = Dao.getInstance();
		// 2.연결맺기
		con = dao.getConnection();
		// 3.쿼리객체 생성
		stmt = con.createStatement();
		// 4.쿼리실행
		System.out.print("제목을 입력하세요>");
		String title = scanner.nextLine();
		System.out.print("내용을 입력하세요>");
		String content = scanner.nextLine();
		String sql = "insert into board2 values(board_seq.nextval,'" + title + "','" + content + "')";
		stmt.executeUpdate(sql);
		// 5.조회
		getBoardList();
	}

	private static void getBoardList() {
		try {
			rs = stmt.executeQuery("select*from board2");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}