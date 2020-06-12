package ch01;

public class SpecializationExample {
	public static void main(String[] args) {
		// 클래스명<타입명> 변수명= new 클래스명<타입명>
		// 컴파일시 T-> String 타입으로 변환
		MyClass<String> s = new MyClass<String>();
		s.set(new String("hello"));// String
		System.out.println(s.get());// String

		MyClass<Integer> s2 = new MyClass<Integer>();
		s2.set(new Integer(10));
		System.out.println(s2.get());
		s2.set(50);
		System.out.println(s2.get());

		// 제네릭 클래스는 컴파일시 타입체킹이 가능
		// s2.set(new String("1"));
	}
}