package ch2_02;

public class ParentMainExample {
	public static void main(String[] args) {
		
		Parent parent = new Child();
		parent.field1 = 10;
		parent.method1();
		// parent.field2=10;
		// parent.method2();
		parent.absMethod();
	}
}