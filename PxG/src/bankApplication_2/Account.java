package bankApplication_2;

public class Account {
	private String ano, owner, password, signdate;
	private double balance;
	private int log;
	/*
	 * ano[primary key] 값에 따른 row를 호출||출력 하여 각 값을 Account객체에 저장. Account 객체 타입의 변수
	 * 리턴, 각 method에서 호출 된 findAccount_method의 값을 Account 객체에 저장 후
	 * gettersetter_method를 이용하여 값 호출
	 */

	public Account(String ano, String owner, String password, String signdate, double balance, int log) {
		this.ano = ano;
		this.owner = owner;
		this.password = password;
		this.signdate = signdate;
		this.balance = balance;
		this.log = log;
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

	public String getSigndate() {
		return signdate;
	}

	public void setSigndate(String signdate) {
		this.signdate = signdate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getLog() {
		return log;
	}

	public void setLog(int log) {
		this.log = log;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}