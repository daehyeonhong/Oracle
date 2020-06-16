package bankApplication_4;

import java.util.Random;

public class RandomIntegerExample {
	public static void main(String[] args) {
		Random random = new Random();
		while (true) {
			double f = 10000, m = 1000, l = 10000;
			double fir = random.nextDouble();
			double mid = random.nextDouble();
			double last = random.nextDouble();
			if (fir < f && mid < m && last < l) {
				double ano = ((fir * 100000000 + mid * 10000 + last));
				System.out.println(ano);
			}
		}
	}
}