package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SaleMainExam2 {
	static Dao dao = Dao.getInstance();
	static Connection con = dao.getConnection();
	private static Scanner scanner = new Scanner(System.in);

	// java프로그램은 db연동시 commit이 자동으로 설정되어있음.
	// java 프로그램은 autocommit 모드(autocommit=true);
	public static void main(String[] args) throws SQLException {
		while (true) {
			System.out.print("등록하려는 품목을 입력하세요>");
			String item = scanner.next();
			// commit 모드를 수동으로 처리
			con.setAutoCommit(false);// commit 수동처리
			// 재고등록
			insertStock(item);
			// 장바구니등록
			bucketProc(item);
			// 구매
			saleProc(item);
			System.out.println("구매확정를 하시겠습니까?");
			char yesNo = scanner.next().charAt(0);
			if (yesNo == 'y' || yesNo == 'Y') {
				con.commit();// DB에 영구저장 method commit()
			} else {
				con.rollback();// 이전 상태로 되돌리기 method rollback()
			}
			System.out.print("계속 등록하시겠습니까?[Y/N]");
			yesNo = scanner.next().charAt(0);
			if (yesNo == 'n' || yesNo == 'N') {
				System.out.println("종료합니다.");
				break;
			}
			// commit모드 자동으로 되돌리기
			con.setAutoCommit(true);// commit자동 처리
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
		stmt.executeUpdate("insert into bucket values( '" + item + "',3)");
		stmt.executeUpdate("update bucket set qty=4 where item='" + item + "'");
	}

	private static void insertStock(String item) {
		// 상품명,수량

		try {
			Statement stmt = con.createStatement();
			// 'mango'재고 있는지 확인

			ResultSet rs = stmt.executeQuery("select count(*)from stock where item='mango'");
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					stmt.executeUpdate("update stock set qty=10 where item ='" + item + "'");
				} else {
					stmt.executeUpdate("insert into stock values('" + item + "',10)");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}