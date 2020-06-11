package ch16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.Policy.Parameters;

public class CalssExample {
	public static void main(String[] args) {
		Car car = new Car();
		// 클래스 정보 얻기
		Class clazz = car.getClass();
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
		try {
			Class clazz2 = Class.forName("ch16.Car");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
			// reflection
			Constructor[] constructors = clazz.getDeclaredConstructors();
			System.out.println(constructors);
			System.out.println("────────────────────────────────────────────────────");
			for (Constructor constructor : constructors) {
				System.out.println(constructor.getName());
				System.out.println(constructor.getParameterCount());
			}
			System.out.println("────────────────────────────────────────────────────");
			for (int i = 0; i < constructors.length; i++) {
				System.out.println(constructors[i].getName());
				System.out.println(constructors[i].getParameterCount());
				Class[] parameters = constructors[i].getParameterTypes();
				for (int j = 0; j < parameters.length; j++) {
					System.out.println(parameters[j]);
				}
			}
			System.out.println("────────────────────────────────────────────────────");
			// method
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(
						method.getName() + "\n" + method.getParameterCount() + "\n" + method.getParameterTypes());
			}
			System.out.println("────────────────────────────────────────────────────");
			for (int i = 0; i < methods.length; i++) {
				System.out.println(methods[i].getName());
				System.out.println(methods[i].getParameterCount());
				System.out.println(methods[i].getParameterTypes());
				Class[] parameters = methods[i].getParameterTypes();
				for (int j = 0; j < parameters.length; j++) {
					System.out.println(parameters[j]);
				}
			} // field
			System.out.println("────────────────────────────────────────────────────");
			Field[] fields = clazz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				System.out.println(fields[i].getType().getSimpleName() + fields[i].getName());
			}
			System.out.println("────────────────────────────────────────────────────");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Car {
	// field
	String model;

	// default constructor
	public Car() {

	}

	// constructor
	public Car(String model) {
		this.model = model;
	}

	// method
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}