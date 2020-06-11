package ch05;

//Exception 객체나 RuntimeException 객체를 상속 받아서 선언
public class NumberException extends RuntimeException {

	public NumberException(String message) {
		super(message);
	}

}