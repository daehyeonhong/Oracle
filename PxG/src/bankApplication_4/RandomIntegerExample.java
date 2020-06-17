package bankApplication_4;

import java.util.Random;

public class RandomIntegerExample {
	public static void main(String[] args) {
		Random random = new Random();
		while (true) {
			int f = 10000, m = 1000, l = 100000;
			double fir = random.nextInt(f);
			double mid = random.nextInt(m);
			double last = random.nextInt(l);

			double ano = (((fir * 100000000) + (mid * 100000) + last));
			double anoFir = fir * 100000000, anoMid = mid * 100000, anoLast = last;

			System.out.println(anoFir);
			System.out.println(anoMid);
			System.out.println(anoLast);
		}
	}
}