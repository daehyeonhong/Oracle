package bankApplication_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class AccountMethod {
	private static Random random = new Random();
	private static Scanner scanner = new Scanner(System.in);
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Account account;
	private static int log;
	private static String sql, ano, owner, password, signdate;
	private static char yesNo;
	private static double balance, amount;
	private static final String LOGON = "로그온";
	private static final String LOGOFF = "로그오프";

	// 연결 객체
	private static Connection Con() throws SQLException {
		Dao dao = Dao.getInstance();
		con = dao.getConnection();
		return con;
	}

	// PreparedStatement 생성
	private static PreparedStatement pstmt(String sql) throws SQLException {
		Dao dao = Dao.getInstance();
		con = dao.getConnection();
		pstmt = con.prepareStatement(sql);
		return pstmt;
	}

	// 실행 확인 입력
	private static boolean yesNo() {
		System.out.println("[Y/N]");
		yesNo = scanner.next().charAt(0);
		return ((yesNo == 'y' || yesNo == 'Y') ? true : false);
	}

	// DB 반영 단순 확인
	private static void chkUpdate(int result) {
		System.out.println(result > 0 ? " 요청 성공!" : " 요청 실패!");
	}

	// 입력 받은 금액 출력
	static String printBalance(double amount) {
		DecimalFormat df = new DecimalFormat("\u00A4 #,###");
		return df.format(amount);
	}

	// 계좌 생성
	static void createAccount() throws SQLException {
		ano = createAno();
		owner = insertOwner();
		balance = initialDeposit();
		password = createPassword();
		pstmt("INSERT INTO BANK(ANO,OWNER,BALANCE,PASSWORD) VALUES(?,?,?,?)");
		pstmt.setString(1, ano);
		pstmt.setString(2, owner);
		pstmt.setDouble(3, balance);
		pstmt.setString(4, password);
		System.out.println(owner + "님 계좌생성");
		chkUpdate(pstmt.executeUpdate());
	}

	// 계좌번호 생성
	private static String createAno() throws SQLException {
		int f = 10000, m = 1000, l = 100000;
		boolean isRun = true;
		while (isRun) {
			double fir = random.nextInt(f), mid = random.nextInt(m), last = random.nextInt(l);
			if (fir < f && mid < m && last < l) {
				double ano = ((fir * 100000000 + mid * 100000 + last));
				System.out.println(ano);
				pstmt("select regexp_replace(ano,'(-){1,}','')from bank where regexp_replace(ano,'(-){1,}','')=?;");
				pstmt.setDouble(1, ano);
				rs = pstmt.executeQuery();
				isRun = ((rs.next()) ? true : false);
			}
		}
		return ano.toString();
	}

	// 계좌주 확인 및 입력
	private static String insertOwner() {
		System.out.print("고객님의 성함을 입력하세요>");
		String owner = scanner.next();
		System.out.print(owner + "님이 맞습니까?");
		return (yesNo() ? owner : null);
	}

	// 비밀번호 생성
	private static String createPassword() {
		System.out.print("설정하려는 비밀번호를 입력하세요> ");
		password = scanner.next();
		return ((chkPwd(password)) ? password : null);
	}

	// 비밀번호 확인
	private static boolean chkPwd(Account account) {
		System.out.print("비밀번호를 입력하세요> ");
		password = scanner.next();
		return (account.getPassword().equals(password) ? true : false);
	}

	// 비밀번호 재확인
	private static boolean chkPwd(String password1) {
		System.out.print("비밀번호 확인> ");
		String password2 = scanner.next();
		return (password1.equals(password2) ? true : false);
	}

	// 초기 입금
	private static double initialDeposit() {
		System.out.print("초기 입금액을 입력하세요> ");
		amount = scanner.nextDouble();
		balance = amount > 0 ? amount : 0;
		System.out.println("초기 입금 액이" + printBalance(balance) + "이 맞습니까?");
		return (yesNo() ? balance : 0);
	}

	// 계좌 조회
	private static Account findAccount() throws SQLException {
		System.out.print("계좌번호 입력> ");
		ano = scanner.next();
		pstmt("SELECT*FROM BANK WHERE ANO=?");
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
	private static String chkLog(int log) {
		return ((log == 1) ? LOGON : LOGOFF);
	}

	// account계정의 로그인 상태 조회
	private static boolean chkLog(Account account) {
		if (account.getLog() == 1) {
			return true;
		}
		System.out.println("로그온 후 다시 이용해 주세요.");
		return false;
	}

	// 계좌 목록 조회-metadata
	static void accountList() throws SQLException {
		System.out.println("┌────────────┐");
		System.out.println("│    계좌목록     │");
		System.out.println("└────────────┘");
		pstmt("SELECT ANO AS 계좌번호,OWNER AS 계좌주,BALANCE AS 잔고,PASSWORD AS 비밀번호,TO_CHAR(SIGNDATE,'RRRR/MM/DD HH24:MI:SS')"
				+ " AS 가입일,LOG AS 로그온여부 FROM BANK ORDER BY ANO");
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
			System.out.println(ano + "\t|" + owner + "\t\t|" + printBalance(balance) + "￦" + "\t|" + password + "\t\t|"
					+ signdate + "|" + chkLog(rs.getInt(6)));
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
			pstmt("UPDATE BANK SET LOG=? WHERE ANO=?");
			if (account.getLog() == 1) {
				System.out.print(account.getOwner() + "님 로그오프 하시겠습니까?");
				if (yesNo()) {
					System.out.print(account.getOwner() + "님 로그오프");
					pstmt.setInt(1, 0);
					pstmt.setString(2, account.getAno());
					pstmt.executeUpdate();
					chkUpdate(pstmt.getUpdateCount());
				} else {
					System.out.println("로그오프 요청이 취소되었습니다.");
				}
			} else {
				if (chkPwd(account)) {
					System.out.print(account.getOwner() + "님 로그온");
					pstmt.setInt(1, 1);
					pstmt.setString(2, account.getAno());
					pstmt.executeUpdate();
					chkUpdate(pstmt.getUpdateCount());
				}
			}
		}
	}

	// 입금
	static void deposit() throws SQLException {
		System.out.print("입금");
		account = findAccount();
		if (account != null) {
			if (chkLog(account)) {
				System.out.print(account.getOwner() + "님 환영합니다.\n입금액을 입력하세요>");
				amount = scanner.nextDouble();
				if (amount >= 0) {
					System.out.print("입금액이 " + printBalance(amount) + "￦이 맞습니까?");
					if (yesNo()) {
						if (amount > 0) {
							System.out.print(account.getOwner() + "님 입금");
							pstmt("UPDATE BANK SET BALANCE=BALANCE+? WHERE ANO=?");
							pstmt.setDouble(1, amount);
							pstmt.setString(2, account.getAno());
							pstmt.executeUpdate();
							chkUpdate(pstmt.getUpdateCount());
						}
					}
				} else {
					System.out.println("잘못된 입력으로 종료합니다.");
				}
			}
		}
	}

	// 출금
	static void withdraw() throws SQLException {
		System.out.println("출금 ");
		account = findAccount();
		if (account != null) {
			if (chkLog(account)) {
				System.out.print(account.getOwner() + "님 환영합니다.\n출금액을 입력하세요>");
				amount = scanner.nextDouble();
				System.out.print("출금액이 " + printBalance(amount) + "￦이 맞습니까?");
				if (yesNo()) {
					if (amount > 0 && (account.getBalance() >= amount)) {
						if (chkPwd(account)) {
							pstmt("UPDATE BANK SET BALANCE=BALANCE-? WHERE ANO=?");
							pstmt.setDouble(1, amount);
							pstmt.setString(2, account.getAno());
							pstmt.executeQuery();
							System.out.print(account.getOwner() + "님 출금");
							chkUpdate(pstmt.getUpdateCount());
						}
					} else {
						System.out.println("잘못된 입력으로 종료합니다.");
					}
				}
			}
		}
	}

	// 예금
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
						amount = scanner.nextDouble();
						System.out.print("이체 금액이 " + printBalance(amount) + "￦이 맞습니까?");
						if (yesNo()) {
							if (amount > 0 && (account.getBalance() >= amount)) {
								if (chkPwd(account)) {
									System.out.print(
											targetAccount.getOwner() + "님에게 " + printBalance(amount) + "￦ 이체.\n실행할까요?");
									if (yesNo()) {
										System.out.println(
												account.getOwner() + "님 " + targetAccount.getOwner() + "님에게 이체");
										con = Con();
										Statement stmt = con.createStatement();
										con.setAutoCommit(false);
										sql = "UPDATE BANK SET BALANCE=BALANCE - " + amount + " WHERE ANO='"
												+ account.getAno() + "'";
										stmt.addBatch(sql);
										sql = "UPDATE BANK SET BALANCE=BALANCE + " + amount + " WHERE ANO='"
												+ targetAccount.getAno() + "'";
										stmt.addBatch(sql);
										int[] result = stmt.executeBatch();
										for (int i : result) {
											System.out.println(i);
										}
										boolean isAllCompleted = false;
										for (int i = 0; i < result.length; i++) {
											System.out.println("*");
											if (result[i] > 0) {
												isAllCompleted = true;
											} else {
												isAllCompleted = false;
												break;
											}
										}
										if (isAllCompleted) {
											System.out.println("이체 성공");
											con.commit();
										} else {
											System.out.println("이체 실패");
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

	// 비밀번호 변경
	static void changePassword() throws SQLException {
		System.out.print("비밀번호 변경");
		account = findAccount();
		if (account != null) {
			if (chkLog(account)) {
				System.out.print(account.getOwner() + "님 비밀번호 변경을 위해 ");
				if (chkPwd(account)) {
					System.out.print("새로운 비밀번호 입력> ");
					password = scanner.next();
					if (!(account.getPassword().equals(password))) {
						if (chkPwd(password)) {
							System.out.println("정말 비밀번호를 변경하시겠습니까?");
							if (yesNo()) {
								pstmt("UPDATE BANK SET PASSWORD=? WHERE ANO=?");
								pstmt.setString(1, password);
								pstmt.setString(2, account.getAno());
								pstmt.executeQuery();
								System.out.print("비밀변경 ");
								chkUpdate(pstmt.getUpdateCount());
							}
						}
					} else {
						System.out.println("현재 사용하는 비밀번호로 변경할 수 없습니다.");
					}
				}
			}
		}
	}

	// 회원 탈퇴
	static void secession() throws SQLException {
		System.out.print("계정 탈퇴");
		account = findAccount();
		if (account != null) {
			if (chkLog(account)) {
				System.out.println(account.getOwner() + "님 계정탈퇴.");
				if (chkPwd(account)) {
					System.out.println("정말 탈퇴하시겠습니까?");
					if (yesNo()) {
						pstmt("DELETE FROM BANK WHERE ANO=?");
						pstmt.setString(1, account.getAno());
						pstmt.executeUpdate();
						chkUpdate(pstmt.getUpdateCount());
					}
				}
			}
		}
	}
}// class