package ch02_03;

import java.util.Vector;

public class VectorMainExample4 {
	public static void main(String[] args) {
		// Vector<Type> 변수 = new Vector<>();
		Vector<Point> v = new Vector<>();
		v.add(new Point(3, 5));
		v.add(new Point(-1, -2));

		System.out.println(v.get(1));
	}
}

class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}