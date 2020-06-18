package ch01;

@FunctionalInterface // 인터페이스가 추상 메소드를 하나만 가지고있는지 확인하는 역할
//람다식으로 사용되는 인터페이스는 추상메소드가 하나만 있어햐함.
public interface MyFunctionalInterface {
	public void method();// 추상 메소드 함수적 인터페이스

	// public void method2();// 2개 이상부터 함수적 인터페이스X
}