package ch06;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public interface ConsumerExample {
	public static void main(String[] args) {

		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t + 8);
			}
		};
		consumer.accept("자바");
		consumer = t -> System.out.println(t + 11);
		consumer.accept("Java");

		BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
		biConsumer.accept("자바", "8");

		DoubleConsumer doubleConsumer = x -> System.out.println("Java" + x);
		doubleConsumer.accept(8.0);

		ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
		objIntConsumer.accept("Java", 11);
	}
}