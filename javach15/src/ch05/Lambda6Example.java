package ch05;

public class Lambda6Example {
	public int outterField = 10;

	class Inner {
		int innerField = 20;

		void method() {
			// 람다식
			MyFunctionalInterface mf = () -> {System.out.println("OutterField: " + outterField);
			System.out.println("OutterField: " + Lambda6Example.this.outterField + "\n");
			System.out.println("innerField: " + innerField);
			System.out.println("innerField: " + this.innerField + "\n");};

			mf.method();
		}
	}
}