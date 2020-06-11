package ch01;

public class HashCodeExample {
	public static void main(String[] args) {
		Car car1 = new Car("소나타");
		Car car2 = new Car("소나타");
		Car car3 = new Car("그랜저");

		// 동등객체=hashCode값이 같고,equals()결과가 true
		System.out.println(car1.hashCode());
		System.out.println(car2.hashCode());
		System.out.println(car3.hashCode());
		System.out.println(car1.equals(car2));
		System.out.println(car1.equals(car3));
		System.out.println(car1.toString());
	}
}

class Car {
	String model;

	public Car(String model) {
		this.model = model;
	}

	@Override
	public int hashCode() {
		return model.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return model.equals(((Car) obj).model);
	}

	@Override
	public String toString() {
		return "Car [model=" + model + "]";
	}

}