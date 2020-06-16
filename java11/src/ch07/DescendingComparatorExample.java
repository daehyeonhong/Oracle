package ch07;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class DescendingComparatorExample {
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new DescendingComparator());
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));

		Iterator<Fruit> itor = treeSet.iterator();
		while (itor.hasNext()) {
			Fruit f = itor.next();
			System.out.println(f.name + "의 가격: " + f.price);
		}
	}
}

class DescendingComparator implements Comparator<Fruit> {
	@Override
	public int compare(Fruit o1, Fruit o2) {
		// 이름, 가격 기준 정렬
		return Objects.hash(o1.name, o1.price) - Objects.hash(o2.name, o2.price);
		// 가격 기준 정렬
		// return Objects.hash(o1.price) - Objects.hash(o2.price);
		// 내림차순 정렬
		// return -(Objects.hash(o1.price) - Objects.hash(o2.price));
	}
}

class Fruit {
	String name;
	int price;

	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}