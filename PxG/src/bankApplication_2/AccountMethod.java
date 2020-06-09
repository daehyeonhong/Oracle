package bankApplication_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountMethod {
	private static Account account;
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Scanner scanner = new Scanner(System.in);
	private static int log, result;
	private static String sql, ano, owner, password, signdate;
	private static char yesNo;
	private static double balance;
	private static final String LOGON = "로그온";
	private static final String LOGOFF = "로그오프";

	// 연결 객체
	private static Connection Con() throws SQLException {
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
				sql = "SELECT ANO FROM BANK WHERE ANO=?";
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
		System.out.print(owner + "님이 맞습니까?");
		if (yesNo()) {
			System.out.println(owner);
			return owner;
		}
		return null;
	}

	// 비밀번호 생성
	private static String createPassword() {
		System.out.print("설정하려는 비밀번호를 입력하세요> ");
		password = scanner.next();
		if (chkPwd(password)) {
			return password;
		} else {
			System.out.println("비밀번호 확인 후 다시 시도하세요.");
		}
		return null;
	}

	// 실행 확인 입력
	private static boolean yesNo() {
		System.out.println("[Y/N]");
		yesNo = scanner.next().charAt(0);
		if (yesNo == 'y' || yesNo == 'Y') {
			return true;
		}
		return false;
	}

	// 비밀번호 확인
	private static boolean chkPwd(Account account) {
		System.out.print("비밀번호를 입력하세요> ");
		password = scanner.next();
		if (account.getPassword().equals(password)) {
			return true;
		}
		System.out.println("비밀번호 확인 후 다시 시도하세요.");
		return false;
	}

	// 비밀번호 재확인
	private static boolean chkPwd(String password1) {
		System.out.print("비밀번호 확인> ");
		String password2 = scanner.next();
		if (password1.equals(password2)) {
			return true;
		}
		return false;
	}

	// 초기 입금
	private static double initialDeposit() {
		System.out.print("초기 입금액을 입력하세요>");
		balance = scanner.nextDouble();
		if (balance > 0) {
			System.out.print("초기 입금액이 " + balance + "￦이 맞습니까?");
			if (yesNo()) {
				return balance;
			}
		}
		System.out.println("잘못된 입력으로 초기 입금액은 0￦ 입니다.");
		return 0;
	}

	// 입금
	static void deposit() throws SQLException {
		System.out.print("입금");
		account = findAccount();
		if (account != null) {
			if (chkLog(account)) {
				System.out.print(account.getOwner() + "님 환영합니다.\n입금액을 입력하세요>");
				balance = scanner.nextDouble();
				System.out.print("입금액이 " + balance + "￦이 맞습니까?");
				if (yesNo()) {
					if (balance > 0) {
						System.out.print(account.getOwner() + "님 입금");
						con = Con();
						sql = "UPDATE BANK SET BALANCE=? WHERE ANO=?";
						pstmt = con.prepareStatement(sql);
						account.setBalance(account.getBalance() + balance);
						if (result > 0) {
							System.out.println("요청 성공!");
						} else {
							System.out.println("요청 실패!");
						}
					}
				}
				System.out.println("잘못된 입력으로 종료합니다.");
			}
		}
	}

	// 계좌 조회
	static Account findAccount() throws SQLException {
		System.out.print("계좌번호 입력> ");
		ano = scanner.next();
		con = Con();
		sql = "SELECT*FROM BANK WHERE ANO=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ano);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			owner = rs.getString(2);
			balance = rs.getDouble(3);
			password = rs.getString(4);
			signdate = rs.getString(5);
			log = rs.getInt(6);
			account = new Account(ano, owner, password, signdate, balance, log);
			return account;
		}
		System.out.println("계좌번호 확인 후 다시 시도하세요.");
		return null;
	}

	// 로그인 상태 조회 DB의 column값
	static String chkLog(int log) {
		if (log == 1) {
			return LOGON;
		}
		return LOGOFF;
	}

	static boolean chkLog(Account account) {
		if (account.getLog() == 1) {
			return true;
		}
		System.out.println("로그온 후 다시 이용해 주세요.");
		return false;
	}

	// 계좌 목록 조회-metadata
	static void accountList() throws SQLException {
		System.out.println("┌────────────┐");
		System.out.println("│    계좌목록    │");
		System.out.println("└────────────┘");
		sql = "SELECT ANO AS 계좌번호,OWNER AS 계좌주,BALANCE AS 잔고,PASSWORD AS 비밀번호,SIGNDATE AS 가입일,"
				+ "LOG AS 로그인여부 FROM BANK ORDER BY ANO";
		con = Con();
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = pstmt.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i) + "\t\t");
		}
		System.out.println();
		while (rs.next()) {
			ano = rs.getString(1);
			owner = rs.getString(2);
			balance = rs.getDouble(3);
			password = rs.getString(4);
			signdate = rs.getString(5);
			System.out.println(ano + "\t|" + owner + "\t\t|" + balance + "￦" + "\t\t|" + password + "\t|" + signdate
					+ "\t|" + chkLog(rs.getInt(6)));
		}
	}

	// 로그온/오프
	static void logOnOff() throws SQLException {
		System.out.println("--------------");
		System.out.println("로그온/오프");
		System.out.println("--------------");
		System.out.print("로그온/오프 하려는 ");
		account = findAccount();
		if (account != null) {
			con = Con();
			sql = "UPDATE BANK SET LOG=? WHERE ANO=?";
			pstmt = con.prepareStatement(sql);
			if (account.getLog() == 1) {
				System.out.print(account.getOwner() + "님 로그오프 하시겠습니까?");
				if (yesNo()) {
					System.out.print(account.getOwner() + "님 로그오프");
					account.setLog(0);
				} else {
					System.out.println("로그오프 요청이 취소되었습니다.");
				}
			} else {
				if (chkPwd(account)) {
					System.out.print(account.getOwner() + "님 로그온");
					account.setLog(1);
				}
			}
			pstmt.setInt(1, account.getLog());
			pstmt.setString(2, account.getAno());
			pstmt.executeUpdate();
			result = pstmt.getUpdateCount();
			if (result > 0) {
				System.out.println(" 요청 성공!");
			} else {
				System.out.println(" 요청 실패!");
			}
		}
	}

	// 출금
	static Account withdraw() throws SQLException {
		System.out.println("출금 ");
		account = findAccount();
		if (account != null) {
			if (chkLog(account)) {
				System.out.print(account.getOwner() + "님 환영합니다.\n출금액을 입력하세요>");
				balance = scanner.nextDouble();
				System.out.print("출금액이 " + balance + "￦이 맞습니까?");
				if (yesNo()) {
					if (balance > 0 && (account.getBalance() >= balance)) {
						if (chkPwd(account)) {
							account.setBalance(account.getBalance() - balance);
							System.out.print(account.getOwner() + "님 출금");
							return account;
						}
					}
				}
				System.out.println("잘못된 입력으로 종료합니다.");
			}
		}
		return null;
	}

	// 계좌이체
	static void transfer() throws SQLException {
		System.out.print("이체 실행 ");
		Account account = findAccount();
		if (account != null) {
			if (chkLog(account)) {
				System.out.print("이체 대상 ");
				Account targetAccount = findAccount();
				if (targetAccount != null) {
					if ((!targetAccount.getAno().equals(account.getAno()))) {
						System.out.print(account.getOwner() + "님 환영합니다.\n이체 금액을 입력하세요> ");
						balance = scanner.nextDouble();
						System.out.print("이체 금액이 " + balance + "￦이 맞습니까?");
						if (yesNo()) {
							if (balance > 0 && (account.getBalance() >= balance)) {
								if (chkPwd(account)) {
									System.out.print(targetAccount.getOwner() + "님에게 " + balance + "￦ 이체.\n실행할까요?");
									if (yesNo()) {
										account.setBalance(account.getBalance() - balance);
										targetAccount.setBalance(targetAccount.getBalance() + balance);
										System.out
												.print(account.getOwner() + "님 " + targetAccount.getOwner() + "님에게 이체");
										con = Con();
										con.setAutoCommit(false);
										sql = "UPDATE BANK SET BALANCE=? WHERE ANO=?";
										pstmt = con.prepareStatement(sql);
										pstmt.setDouble(1, account.getBalance());
										pstmt.setString(2, account.getAno());
										pstmt.addBatch();
										pstmt.setDouble(1, targetAccount.getBalance());
										pstmt.setString(2, targetAccount.getAno());
										pstmt.addBatch();
										int[] result = pstmt.executeBatch();
										boolean isAllCompleted = false;
										for (int i = 0; i < result.length; i++) {
											if (result[i] > 0) {
												isAllCompleted = true;
											} else {
												isAllCompleted = false;
												break;
											}
										}
										if (isAllCompleted) {
											con.commit();
										} else {
											con.rollback();
										}
									} else {
										System.out.println("이체 요청 취소.");
									}
								}
							}
						} else {
							System.out.println("잘못된 입력으로 종료합니다.");
						}
					} else {
						System.out.println("같은 계좌로 이체할 수 없습니다.");
					}
				}
			}
		}
		con.setAutoCommit(true);
	}
}// class