package ch05;

public class BalanceOutofException extends Exception {

	public BalanceOutofException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BalanceOutofException() {
		this("잔고가 부족합니다.");
	}

}