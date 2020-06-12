package bankApplication_4;

public class Random {
	public static void main(String[] args) {

		java.util.Random random = new java.util.Random();
		int f = 10000, m = 1000, l = 100000;
		String ano = null;
		while (true) {
			int fir = (random.nextInt(f) + (f / 10));
			int mid = random.nextInt(m) + (m / 10);
			int last = random.nextInt(l) + (l / 10);
			if (fir < f && mid < m && last < l) {
				ano = (fir + "-" + mid + "-" + last);
				System.out.println(ano);
			}
		}
	}
}
