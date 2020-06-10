package ch05;

public class AccountMainExample {
	public static void main(String[] args) {
		Account acc = new Account();
		acc.setAno("111-12");
		acc.setOwner("홍길동");
		acc.setBalance(10000);
		acc.deposit(5000);
		System.out.println(acc.balance);
		try {
			acc.withdraw(5000);
			System.out.println(acc.balance);
			acc.withdraw(20000);// 오류 발생
			System.out.println(acc.balance);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}