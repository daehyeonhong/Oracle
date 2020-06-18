package ch03;

public class Lambda4Example {
	public static void main(String[] args) {
		MyFuntcionalInterface mf = new MyFuntcionalInterface() {

			@Override
			public int method(int x, int y) {
				return x + y;
			}
		};
		int result = mf.method(10, 20);
		System.out.println(result);
		System.out.println(mf.method(20, 5));

		// 명령문이 한 개인 경우 {}제거, {}이 없으면 return도 제거
		MyFuntcionalInterface mf2 = (x, y) -> x * y;
		int result2 = mf2.method(30, 50);
		System.out.println(result2);
	}
}