package ch08;

import java.text.DecimalFormat;
import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));

		DecimalFormat df = new DecimalFormat("\u00A4 #,###");

		while (!coinBox.isEmpty()) {
			System.out.println(coinBox.peek().getValue());// 삭제하지 않고 보여주는 method peek()
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전: " + df.format(coin.getValue()));
		}
	}
}

class Coin {
	private int value;

	public Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}