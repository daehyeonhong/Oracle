package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SaleMainExam {
	static Dao dao = Dao.getInstance();
	static Connection con = dao.getConnection();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		while (true) {
			System.out.print("등록하려는 품목을 입력하세요>");
			String item = scanner.next();
			// 재고등록
			insertStock(item);
			// 장바구니등록
			bucketProc(item);
			// 구매
			saleProc(item);
			System.out.print("계속 등록하시겠습니까?[Y/N]");
			char yesNo = scanner.next().charAt(0);
			if (yesNo == 'n' || yesNo == 'N') {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

	private static void saleProc(String item) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("insert into sale values((select nvl(max(seq),0)+1 from sale),'hong','" + item
					+ "',(select qty from bucket where item='" + item + "'),sysdate)");
			// 재고 변경 처리
			stmt.executeUpdate("update stock set qty=qty-(select qty from bucket where item='" + item + "')where item='"
					+ item + "'");
			// 장바구니 비우기
			stmt.executeUpdate("delete from bucket");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void bucketProc(String item) throws SQLException {
		Statement stmt = con.createStatement();
		int qty = 0;
		System.out.print("장바구니 추가 수량 입력>");
		qty = scanner.nextInt();
		if (qty > 0) {
			ResultSet rs = stmt.executeQuery("select count(*) from bucket where item='" + item + "'");
			rs.next();
			if (rs.getInt(1) > 0) {
				stmt.executeUpdate("update bucket set qty=+" + qty + " where item ='" + item + "'");
			} else {
				stmt.executeUpdate("insert into bucket values('" + item + "'," + qty + ")");
			}
		}
		System.out.print("장바구니 수량 변경하시겠습니까?[Y/N]");
		ResultSet rs = stmt.executeQuery("select qty from bucket where item='" + item + "'");
		System.out.println(rs);
		char yesNo = scanner.next().charAt(0);
		if (yesNo == 'n' || yesNo == 'N') {
			System.out.println("종료합니다.");
		} else {
			System.out.print("변경할 수량>");
			qty = scanner.nextInt();
			stmt.executeUpdate("update bucket set qty=" + qty + " where item='" + item + "'");
		}
	}

	private static void insertStock(String item) {
		// 상품명,수량
		try {
			int qty = 0;
			System.out.print("재고 추가 수량 입력>");
			qty = scanner.nextInt();
			if (qty > 0) {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from stock where item='" + item + "'");
				rs.next();
				if (rs.getInt(1) > 0) {
					stmt.executeUpdate("update stock set qty=+" + qty + " where item ='" + item + "'");
				} else {
					stmt.executeUpdate("insert into stock values('" + item + "'," + qty + ")");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}