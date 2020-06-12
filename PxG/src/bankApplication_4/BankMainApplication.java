package bankApplication_4;

import java.sql.SQLException;
import java.util.Scanner;

public class BankMainApplication {
	private static Scanner scanner = new Scanner(System.in);

	static String[] menuArr = { "계좌생성", "계좌조회", "로그온/로그오프", "입금", "출금", "예금", "비밀번호 변경", "회원탈퇴" };

	public static void main(String[] args) throws SQLException {
		boolean isRun = true;
		while (isRun) {
			int menu = selectMenu();
			if (menu > 0) {
				if (menu <= menuArr.length) {
					System.out.println(menuArr[menu - 1]);
				}
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
				AccountMethod.deposit();
				break;
			case 5:
				AccountMethod.withdraw();
				break;
			case 6:
				AccountMethod.transfer();
				break;
			case 7:
				AccountMethod.changePassword();
				break; // 비밀번호를 변경하는 메소드 추가
			case 8:
				AccountMethod.secession();
				break;
			default:
				isRun = !isRun;
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
	}

	// ┌┐└┘│ ┬───────────────┴
	private static int selectMenu() {
		System.out.println(
				"┌───────────────┬───────────────┬───────────────┬───────┬───────┬───────┬───────────────┬────────┐");
		System.out.println("│1.계좌생성\t│2.계좌조회\t│3.로그온/로그오프\t│4.입금\t│5.출금\t│6.예금\t│7.비밀번호 변경\t│8.회원탈퇴 │");
		System.out.println(
				"└───────────────┴───────────────┴───────────────┴───────┴───────┴───────┴───────────────┴────────┘");
		System.out.print("메뉴를 선택하세요>");
		int insertNum = scanner.nextInt();
		if (insertNum > 0) {
			if (insertNum <= menuArr.length) {
				System.out.print(insertNum + "번 ");
			}
		}
		return insertNum;
	}
}