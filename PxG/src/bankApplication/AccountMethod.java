package bankApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountMethod {
	private static AccountObject account;
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Scanner scanner = new Scanner(System.in);
	private static String sql, ano, owner, password, signdate;
	private static char yesNo;
	private static double balance;
	private static final String LOGON = "로그온";
	private static final String LOGOFF = "로그오프";

	public static Connection Con() throws SQLException {
		Dao dao = Dao.getInstance();
		con = dao.getConnection();
		return con;
	}

	// 계좌 생성
	public static void createAccount() throws SQLException {
		ano = createAno();
		owner = insertOwner();
		balance = initialDeposit();
		password = createPassword();
		sql = "INSERT INTO BANK(ANO,OWNER,BALANCE,PASSWORD) VALUES(?,?,?,?)";
		con = Con();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ano);
		pstmt.setString(2, owner);
		pstmt.setDouble(3, balance);
		pstmt.setString(4, password);
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("계좌생성 성공!");
		} else {
			System.out.println("계좌생성 실패!");
		}
	}

	// 계좌번호 생성
	private static String createAno() throws SQLException {
		int f = 10000, m = 1000, l = 100000;
		ano = null;
		while (true) {
			int fir = (int) (Math.random() * f);
			int middle = (int) (Math.random() * m);
			int last = (int) (Math.random() * l);
			if (fir > (f / 10) && middle > (m / 10) && last > (l / 10)) {
				ano = (fir + "-" + middle + "-" + last);
				System.out.println(ano);
				con = Con();
				sql = "select ano from BANK where ano=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ano);
				rs = pstmt.executeQuery();
				if (!rs.next()) {
					return ano;
				}
			}
		}
	}

	// 계좌주 확인 및 입력
	private static String insertOwner() {
		System.out.print("고객님의 성함을 입력하세요>");
		String owner = scanner.next();
		System.out.print(owner + "님이 맞습니까?[Y/N]");
		yesNo = scanner.next().charAt(0);
		if (yesNo == 'y' || yesNo == 'Y') {
			System.out.println(owner);
			return owner;
		}
		return null;
	}

	// 비밀번호 생성
	private static String createPassword() {
		System.out.print("설정하려는 비밀번호를 입력하세요.");
		password = scanner.next();
		if (chkPwd(password)) {
			return password;
		} else {
			System.out.println("비밀번호 확인 후 다시 시도하세요.");
		}
		return null;
	}

	// 비밀번호 확인
	private static boolean chkPwd(AccountObject account) {
		System.out.print("비밀번호를 입력하세요>");
		password = scanner.next();
		if (account.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	// 비밀번호 재확인
	private static boolean chkPwd(String password1) {
		System.out.print("비밀번호 확인: ");
		String password2 = scanner.next();
		boolean chkPwd = false;
		if (password1.equals(password2)) {
			chkPwd = !chkPwd;
		}
		return chkPwd;
	}

	// 초기 입금
	private static double initialDeposit() {
		System.out.print("초기 입금액을 입력하세요>");
		balance = scanner.nextDouble();
		if (balance > 0) {
			System.out.print("초기 입금액이 " + balance + "￦이 맞습니까?[Y/N]");
			yesNo = scanner.next().charAt(0);
			if (yesNo == 'y' || yesNo == 'Y') {
				return balance;
			}
		}
		System.out.println("잘못된 입력으로 초기 입금액은 0￦ 입니다.");
		return 0;
	}

	// 입금
	static double deposit() throws SQLException {
		System.out.println("계좌 입력");
		ano = scanner.next();
		account = findAccount(ano);
		if (chkLog(account.getLog())) {
			System.out.print(owner + "님 환영합니다.\n입금액을 입력하세요>");
			balance = scanner.nextDouble();
			System.out.print("입금액이 " + balance + "￦이 맞습니까?[Y/N]");
			yesNo = scanner.next().charAt(0);
			if (yesNo == 'y' || yesNo == 'Y') {
				if (balance > 0) {
					return balance;
				}
			}
			System.out.println("잘못된 입력으로 종료합니다.");
		} else {
			System.out.println("로그인 후 다시 시도하세요.");
		}
		return 0;
	}

	// 계좌 조회
	public static AccountObject findAccount(String ano) throws SQLException {
		con = Con();
		sql = "select*from BANK where ano=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ano);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			owner = rs.getString(2);
			balance = rs.getDouble(3);
			password = rs.getString(4);
			signdate = rs.getString(5);
			account = new AccountObject(ano, owner, password, signdate, balance, chkLog(rs.getInt(6)));
			return account;
		}
		return null;
	}

	// 로그인 상태 조회 DB의 column값
	public static String chkLog(int log) {
		if (log == 1) {
			return LOGON;
		}
		return LOGOFF;
	}

	// 로그인 상태 조회 AccountObject 객체의 log값
	public static boolean chkLog(String log) {
		if (log.equals(LOGON)) {
			return true;
		}
		return false;
	}

	// 계좌 목록 조회-metadata
	public static void accountList() throws SQLException {
		System.out.println("┌────────────┐");
		System.out.println("│    계좌목록    │");
		System.out.println("└────────────┘");
		sql = "SELECT ANO AS 계좌번호,OWNER AS 계좌주,BALANCE AS 잔고,PASSWORD AS 비밀번호,SIGNDATE AS 가입일,"
				+ "LOGON AS 로그인여부 FROM BANK ORDER BY ANO";
		con = Con();
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = pstmt.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i) + "\t\t");
		}
		getAccount();
		System.out.println();
		while (rs.next()) {
			ano = rs.getString(1);
			owner = rs.getString(2);
			balance = rs.getDouble(3);
			password = rs.getString(4);
			signdate = rs.getString(5);
			System.out.println(ano + "\t|" + owner + "\t\t|" + balance + "￦" + "\t|" + password + "\t|" + signdate
					+ "\t|" + chkLog(rs.getInt(6)));
		}
	}

	// 계좌 목록 조회
	public static void getAccount() throws SQLException {
		sql = "SELECT*FROM BANK";
		con = Con();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		/*
		 * while (rs.next()) { System.out.println(rs.getString(1) + "\t|" +
		 * rs.getString(2) + "\t|" + rs.getDouble(3) + "\t|" + rs.getString(4) + "\t|" +
		 * rs.getString(5) + "\t|" + chkLog(rs.getInt(6))); }
		 */
	}

	public static void logOnOff() throws SQLException {
		System.out.println("--------------");
		System.out.println("로그인&로그아웃");
		System.out.println("--------------");
		System.out.print("계좌번호를 입력하세요.");
		ano = scanner.next();
		account = findAccount(ano);
		con = Con();
		if (account != null) {
			sql = "UPDATE BANK SET LOGON=? WHERE ANO = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setString(2, ano);
			if (chkLog(account.getLog())) {
				System.out.print(account.getOwner() + "님 로그오프 하시겠습니까?[Y/N]");
				yesNo = scanner.next().charAt(0);
				if (yesNo == 'y' || yesNo == 'Y') {
					System.out.println(account.getOwner() + "님 로그오프 되었습니다.");
					pstmt.setInt(1, 0);
				} else {
					System.out.println("로그오프 요청이 취소되었습니다.");
				}
			} else {
				if (chkPwd(account)) {
					System.out.println(account.getOwner() + "님 로그온 되었습니다.");
				} else {
					pstmt.setInt(1, 0);
				}
			}
		} else {
			System.out.println("계좌번호 확인 후 다시 시도하세요.");
		}
		pstmt.executeUpdate();
	}

}// class