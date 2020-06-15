package ch03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample3 {
	public static void main(String[] args) {
		List<Account> list = new ArrayList<Account>();

		list.add(new Account("111-001", "홍길동", 100000));
		list.add(new Account("111-002", "일지매", 100000));
		list.add(new Account("111-003", "임꺽정", 100000));

		Iterator<Account> itor = list.iterator();

		while (itor.hasNext()) {
			System.out.println(itor.next());
		}

		System.out.println("─────────────────────────────────────────────");

		for (Account account : list) {
			System.out.println(account);
		}

		System.out.println("─────────────────────────────────────────────");

		boolean isExists = list.contains(new Account("111-002", "일지매", 100000));

		System.out.println(isExists ? "계좌가 존재합니다." : "계좌가 없습니다.");

		for (int i = 0; i < list.size(); i++) {
			Account acc = list.get(i);
			if (acc.equals(new Account("111-002", "일지매", 100000))) {
				System.out.print(acc);
				break;
			}
		}
	}
}

class Account {
	String ano;
	String owner;
	int balance;

	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	void deposit(int amount) {
		this.balance += amount;
	}

	void withdraw(int amount) throws Exception {
		if (this.balance - amount < 0) {
			throw new Exception("잔고 부족");
		} else {
			this.balance -= amount;
		}
	}

	@Override
	public String toString() {
		return "계좌번호: " + ano + "\t| 계좌주: " + owner + "\t| 잔고: " + balance;
	}

	@Override
	public int hashCode() {
		return this.ano.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			return ano.equals(((Account) obj).ano);
		}
		return false;
	}
}