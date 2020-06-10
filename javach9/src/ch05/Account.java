package ch05;

public class Account {
	String ano;
	String owner;
	int balance;

	public Account() {
	}

	// 입금
	void deposit(int amount) {
		balance += amount;
	}

	// 출금
	void withdraw(int amount) throws Exception {
		if (balance - amount <= 0)
			throw new BalanceOutofException();
		{
			balance -= amount;
		}
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}