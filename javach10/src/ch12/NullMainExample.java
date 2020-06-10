package ch12;

import java.util.Objects;
import java.util.function.Supplier;

public class NullMainExample {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = null;
		System.out.println(Objects.isNull(str1));// not null
		System.out.println(Objects.requireNonNull(str1));// 객체 리턴
		try {
			// null-NullPointerException
			System.out.println(Objects.requireNonNull(str2));//
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(Objects.requireNonNull(str2, "nullpoint"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(Objects.requireNonNull(str2, new Supplier<String>() {

				@Override
				public String get() {
					return "너얼 포인트 오류.";
				}
			}));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}try {
			System.out.println(Objects.requireNonNull(str2, new Supplier<String>() {

				@Override
				public String get() {
					return "너얼 포인트 오류.";
				}
			}));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 람다식
		// 인터페이스명 삭제,메소드명 삭제,명령문이 하나면{}생략,선언부()-> 실행부{};
		try {
			System.out.println(Objects.requireNonNull(str2, () -> "너얼 포인트 오류."));
		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}

	class SupplierClass implements Supplier<String> {
		@Override
		public String get() {
			return "널 포인트 오류.";
		}
	}

// 무명(익명) 객체

	/*
	 * public static String requireNonNull(String obj, Supplier<String>
	 * messageSupplier) { if (obj == null) throw new
	 * NullPointerException(messageSupplier.get()); return obj; }
	 */
	/*
	 * public interface Supplier<String> {
	 * 
	 *//**
		 * Gets a result.
		 *
		 * @return a result
		 *//*
			 * String get(); }
			 */
}