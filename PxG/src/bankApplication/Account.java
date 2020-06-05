package bankApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {
	private static Scanner scanner = new Scanner(System.in);
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static String sql;
	private static String ano;
	private static String owner;
	private static double balance;
	private static String password;
	private static int logon;

	public Account() {
	}

	public Connection Con() throws SQLException {
		Dao dao = Dao.getInstance();
		con = dao.getConnection();
		return con;
	}

	public String getAccount(String ano) throws SQLException {
		sql = "select*from bank where ano=?";
		con = Con();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ano);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			ano = rs.getString(1);
		} else {
			ano = null;
		}
		return ano;
	}

	public void getAccount() throws SQLException {
		sql = "select*from bank";
		con = Con();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		String logon;
		while (rs.next()) {
			if (rs.getInt(6) == 0) {
				logon = "off";
			} else {
				logon = "on";
			}
			System.out.println(rs.getString(1) + "\t|" + rs.getString(2) + "\t|" + rs.getInt(3) + "\t|"
					+ rs.getString(4) + "\t|" + rs.getString(5) + "\t|" + logon);
		}
	}

	public void setAccount() throws SQLException {
		sql = "insert into bank(ano,owner,balance,password) values(?,?,?,?)";
		String ano = makeAno();
		String owner = insertOwner();
		double balance = fDeposit();
		String password = mkPassword();
		con = Con();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ano);
		pstmt.setString(2, owner);
		pstmt.setDouble(3, balance);
		pstmt.setString(4, password);
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("가입성공!");
		} else {
			System.out.println("가입실패!");
		}
	}

	public void findAccount() throws SQLException {
		System.out.println("┌────────────┐");
		System.out.println("│    계좌목록    │");
		System.out.println("└────────────┘");
		sql = "select ano AS 계좌번호, owner as 계좌주,balance as 잔고,password as 비밀번호,signdate as 가입일,logon as 로그인여부 from bank order by ano";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = pstmt.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i) + "\t");
		}
		getAccount();
		System.out.println();
		while (rs.next()) {
			ano = rs.getString(1);
			owner = rs.getString(2);
			balance = rs.getDouble(3);
			password = rs.getString(4);
			System.out.println(ano + "|" + owner + "|" + balance + "￦" + "|" + password + "|" + logon);
		}
	}

	private String mkPassword() {
		System.out.print("설정하려는 비밀번호를 입력하세요.");
		String password = scanner.next();
		if (setPassword(password) == null) {
			System.out.println("비밀번호 확인 후 다시 시도하세요.");
		} else {
			return password;
		}
		return null;
	}

	private String setPassword(String password) {
		System.out.print("비밀번호 확인: ");
		String password2 = scanner.next();
		if (password.equals(password2)) {
		} else {
			password = null;
		}
		return password;
	}

	private double fDeposit() {
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
	private String makeAno() {
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

	private String insertOwner() {
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