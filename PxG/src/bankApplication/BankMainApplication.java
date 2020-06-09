package bankApplication;

import java.sql.SQLException;
import java.util.Scanner;

public class BankMainApplication {
	private static Scanner scanner = new Scanner(System.in);

	static String[] menuArr = { "계좌생성", "계좌조회", "로그인/로그아웃", "입금", "출금", "예금", "비밀번호 변경", "회원탈퇴" };

	public static void main(String[] args) throws SQLException {
		boolean isRun = true;
		while (isRun) {
			int menu = selectMenu();
			if (menu > 0 && menu <= menuArr.length) {
				System.out.println(menuArr[menu - 1]);
			}
			switch (menu) {
			case 0:
				break;
			case 1:
				AccountMethod.createAccount();
				break;
			case 2:
				AccountMethod.accountList();
				break;
			case 3:
				AccountMethod.logOnOff();
				break;
			case 4:
				AccountMethod.updateAccount(AccountMethod.deposit());
				break;
			case 5:
				withdraw();
				break;
			case 6:
				transfer();
				break;
			case 7:
				changePassword();
				break; // 비밀번호를 변경하는 메소드 추가
			case 8:
				secession();
				break;
			default:
				isRun = !isRun;
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
	}

	private static void withdraw() {
		// TODO Auto-generated method stub

	}

	private static void transfer() {
		// TODO Auto-generated method stub

	}

	private static void changePassword() {
		// TODO Auto-generated method stub

	}

	private static void secession() {
		// TODO Auto-generated method stub

	}

	// ┌┐└┘│ ┬───────────────┴
	private static int selectMenu() {
		System.out.println(
				"┌───────────────┬───────────────┬───────────────┬───────┬───────┬───────┬───────────────┬────────┐");
		System.out.println("│1.계좌생성\t│2.계좌조회\t│3.로그인/로그아웃\t│4.입금\t│5.출금\t│6.예금\t│7.비밀번호 변경\t│8.회원탈퇴│");
		System.out.println(
				"└───────────────┴───────────────┴───────────────┴───────┴───────┴───────┴───────────────┴────────┘");
		System.out.print("메뉴를 선택하세요>");
		int insertNum = scanner.nextInt();
		if (insertNum > 0 && insertNum <= menuArr.length) {
			System.out.print(insertNum + "번 ");
		} else {
			System.out.println("메뉴 확인 후 다시 선택하세요.");
			insertNum = 0;
		}
		return insertNum;
	}
}