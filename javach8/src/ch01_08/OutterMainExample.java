package ch01_08;

public class OutterMainExample {
	public static void main(String[] args) {
		Outter outter = new Outter();
		Outter.Nested nest = outter.new Nested();
		System.out.println(nest.field);
		nest.method();
		nest.print();
	}
}