package bankApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		Dao dao = Dao.getInstance();
		Connection con = dao.getConnection();
		String sql = "insert into bank(ano,owner,balance,password) values(?,?,?,?)";
		String ano = makeAno();
		String owner = insertOwner();
		double balance = fDeposit();
		String password = mkPassword();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ano);
		pstmt.setString(2, owner);
		pstmt.setDouble(3, balance);
		pstmt.setString(4, password);
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("입력성공!");
		} else {
			System.out.println("입력실패!");
		}
		sql = "select ano,owner,balance,password from bank order by ano";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ano = rs.getString(1);
			owner = rs.getString(2);
			balance = rs.getDouble(3);
			password = rs.getString(4);
			System.out.println(ano + "|" + owner + "|" + balance + "￦" + "|" + password);
		}
	}

	private static String mkPassword() {
		System.out.print("설정하려는 비밀번호를 입력하세요.");
		String password = scanner.next();
		if (setPassword(password) == null) {
			System.out.println("비밀번호 확인 후 다시 시도하세요.");
		} else {
			return password;
		}
		return null;
	}

	private static String setPassword(String password) {
		System.out.print("비밀번호 확인: ");
		String password2 = scanner.next();
		if (password.equals(password2)) {
		} else {
			password = null;
		}
		return password;
	}

	private static double fDeposit() {
		System.out.print("초기 입금액을 입력하세요>");
		double money = scanner.nextDouble();
		if (money > 0) {
			System.out.print("초기 입금액이 " + money + "￦이 맞습니까?[Y/N]");
			char yesNo = scanner.next().charAt(0);
			if (yesNo == 'y' || yesNo == 'Y') {
				return money;
			}
		}
		System.out.println("잘못된 입력으로 초기 입금액은 0원 입니다.");
		return 0;
	}

	// 계좌번호 생성
	private static String makeAno() {
		int f = 10000, m = 1000, l = 100000;
		String ano = null;
		while (true) {
			int fir = (int) (Math.random() * f);
			int middle = (int) (Math.random() * m);
			int last = (int) (Math.random() * l);
			if (fir > (f / 10) && middle > (m / 10) && last > (l / 10)) {
				ano = (fir + "-" + middle + "-" + last);
				System.out.println(ano);
				if (ano != null) {
					return ano;
				}
			}
		}
	}

	private static String insertOwner() {
		System.out.print("고객님의 성함을 입력하세요>");
		String owner = scanner.next();
		System.out.print(owner + "님이 맞습니까?[Y/N]");
		char yesNo = scanner.next().charAt(0);
		if (yesNo == 'y' || yesNo == 'Y') {
			return owner;
		}
		return null;
	}
}